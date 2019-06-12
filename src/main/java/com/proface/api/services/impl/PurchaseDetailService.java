package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.exceptions.customs.ProfaceInvalidStatusException;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.services.IPurchaseDetailService;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.services.IReceptionStatusService;
import com.proface.api.util.ProfaceCurrencyExchanger;

@Service
public class PurchaseDetailService
		extends ProfaceService<PurchaseDetailRepository, PurchaseDetail, PurchaseDetailPK, String>
		implements IPurchaseDetailService {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	@Autowired
	private IReceptionStatusService receptionStatusService;

	@Override
	public void save(PurchaseDetail entity) {
		setId(entity);
		super.save(entity);
	}

	@Override
	public void edit(PurchaseDetailPK id, PurchaseDetail entity) {
		entity.setId(id);
		setId(entity);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return PurchaseDetail.class.getSimpleName();
	}

	@Override
	protected void prepareEntity(PurchaseDetail entity) {
		if (entity.getStatus() == null) {
			entity.setStatus(receptionStatusService.findOne("nativeId:I"));
		}
		if (entity.getPurchase() != null) {
			if (entity.getPurchase().getStatus() != null) {
				if (!entity.getPurchase().getStatus().getNativeId().equals("CR")) {
					entity.setPurchasePrice(entity.getQuantity() * entity.getUnitPrice());
					entity.setFinalPrice(entity.getPurchasePrice() - entity.getDisscount());
					entity.setLocalPrice(ProfaceCurrencyExchanger.fromCurrencyToCurrency(
							entity.getPurchase().getCurrency().getId(), "PEN", entity.getFinalPrice()));
				}
			}
			entity.getPurchase().setTotal(entity.getPurchase().getTotal() + entity.getFinalPrice());
			entity.getPurchase().setDetails(null);
			purchaseOrderService.edit(entity.getPurchase().getId(), entity.getPurchase());
		}
	}

	@Override
	protected void setId(PurchaseDetail entity) {
		if (entity.getId() == null) {
			entity.setId(new PurchaseDetailPK(entity.getProduct() == null ? 0 : entity.getProduct().getId(),
					entity.getPurchase() == null ? 0 : entity.getPurchase().getId()));
		}
	}

	@Override
	protected void compareEntity(PurchaseDetail entity, PurchaseDetail repositoryEntity) {
		double totalVariation = entity.getFinalPrice() - repositoryEntity.getFinalPrice();
		entity.getPurchase()
				.setTotal(repositoryEntity.getPurchase().getTotal() + totalVariation - entity.getFinalPrice());
		if (entity.getStatus() != null) {
			if (entity.getStatus().getOrder() < repositoryEntity.getStatus().getOrder()) {
				throw new ProfaceInvalidStatusException(
						String.format("No se puede actualizar del estado %s al estado %s",
								repositoryEntity.getStatus().getDescription(), entity.getStatus().getDescription()));
			}
		}
		purchaseOrderService.edit(entity.getPurchase().getId(), entity.getPurchase());
	}

	@Override
	protected void resetEntity(PurchaseDetail entity) {
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() - entity.getFinalPrice());
		purchaseOrderService.edit(entity.getPurchase().getId(), entity.getPurchase());
	}

}
