package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.repositories.PurchaseCostRepository;
import com.proface.api.services.IPurchaseCostService;
import com.proface.api.services.IPurchaseOrderService;

@Service
public class PurchaseCostService extends ProfaceService<PurchaseCostRepository, PurchaseCost, Integer, Integer>
		implements IPurchaseCostService {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	@Override
	public void save(PurchaseCost entity) {
		entity.setId(0);
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
		double totalVariation = entity.getTotalCost() - repositoryEntity.getTotalCost();
		entity.getPurchase()
				.setTotal(repositoryEntity.getPurchase().getTotal() + totalVariation - entity.getTotalCost());
		purchaseOrderService.save(entity.getPurchase());
	}

	@Override
	protected void prepareEntity(PurchaseCost entity) {
		entity.getPurchase().setTotal(entity.getPurchase().getTotal() + entity.getTotalCost());
		purchaseOrderService.save(entity.getPurchase());
	}

}
