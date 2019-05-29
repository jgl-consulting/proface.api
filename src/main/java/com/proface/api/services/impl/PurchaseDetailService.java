package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseDetailService;

@Service
public class PurchaseDetailService
		extends BaseService<PurchaseDetailRepository, PurchaseDetail, PurchaseDetailPK, String>
		implements IPurchaseDetailService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Override
	public void save(PurchaseDetail entity) {
		entity.setId(getId(entity));
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + entity.getFinalPrice());
		purchaseOrderRepository.save(entity.getPurchase());
		super.save(entity);
	}

	@Override
	public void edit(PurchaseDetailPK id, PurchaseDetail entity) {
		entity.setId(id == null ? getId(entity) : id);
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
	}

	private PurchaseDetailPK getId(PurchaseDetail entity) {
		return new PurchaseDetailPK(entity.getProduct() == null ? 0 : entity.getProduct().getId(),
				entity.getPurchase() == null ? 0 : entity.getPurchase().getId());
	}
	
	@Override
	protected void compareEntity(PurchaseDetail entity, PurchaseDetail repositoryEntity) {
		prepareEntity(entity);
		double priceVar = entity.getFinalPrice() - repositoryEntity.getFinalPrice();
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + priceVar);
		purchaseOrderRepository.save(entity.getPurchase());
	}

}
