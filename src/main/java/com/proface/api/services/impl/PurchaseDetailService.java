package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.services.IPurchaseDetailService;
import com.proface.api.services.IPurchaseOrderService;

@Service
public class PurchaseDetailService
		extends ProfaceService<PurchaseDetailRepository, PurchaseDetail, PurchaseDetailPK, String>
		implements IPurchaseDetailService {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

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
		entity.setPurchasePrice(entity.getQuantity() * entity.getUnitPrice());
		entity.setFinalPrice(entity.getPurchasePrice() - entity.getDisscount());
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + entity.getFinalPrice());
		purchaseOrderService.save(entity.getPurchase());
	}

	@Override
	protected void setId(PurchaseDetail entity) {
		if (entity.getId() != null) {
			entity.setId(new PurchaseDetailPK(entity.getProduct() == null ? 0 : entity.getProduct().getId(),
					entity.getPurchase() == null ? 0 : entity.getPurchase().getId()));
		}
	}

	@Override
	protected void compareEntity(PurchaseDetail entity, PurchaseDetail repositoryEntity) {
		double totalVariation = entity.getFinalPrice() - repositoryEntity.getFinalPrice();
		entity.getPurchase()
				.setTotal(repositoryEntity.getPurchase().getTotal() + totalVariation - entity.getFinalPrice());
		purchaseOrderService.save(entity.getPurchase());
	}

}
