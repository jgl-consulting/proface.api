package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.repositories.PurchaseCostRepository;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseCostService;

@Service
public class PurchaseCostService extends BaseService<PurchaseCostRepository, PurchaseCost, Integer, Integer>
		implements IPurchaseCostService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Override
	public void save(PurchaseCost entity) {
		entity.setId(0);
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + entity.getTotalCost());
		purchaseOrderRepository.save(entity.getPurchase());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, PurchaseCost entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return PurchaseCost.class.getSimpleName();
	}
	
	@Override
	protected void compareEntity(PurchaseCost entity, PurchaseCost repositoryEntity) {
		double priceVar = entity.getTotalCost() - repositoryEntity.getTotalCost();
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + priceVar);
		purchaseOrderRepository.save(entity.getPurchase());
	}

}
