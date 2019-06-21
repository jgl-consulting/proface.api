package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.repositories.PurchaseCostRepository;
import com.proface.api.services.IPurchaseCostService;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.util.ProfaceCurrencyExchanger;

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
	protected void prepareEntity(PurchaseCost entity) {
		entity.setLocalCost(ProfaceCurrencyExchanger.fromCurrencyToCurrency(entity.getCurrency().getId(), "PEN",
				entity.getTotalCost()));
		if (entity.getPurchase() != null) {
			PurchaseOrder purchase = purchaseOrderService.findOne(entity.getPurchase().getId());
			purchase.setLocalCost(purchase.getLocalCost() + entity.getLocalCost());
			purchaseOrderService.edit(purchase.getId(), purchase);
		}
	}

	@Override
	protected void compareEntity(PurchaseCost entity, PurchaseCost repositoryEntity) {
		double totalVariation = entity.getLocalCost() - repositoryEntity.getLocalCost();
		entity.getPurchase()
				.setLocalCost(repositoryEntity.getPurchase().getLocalCost() + totalVariation - entity.getLocalCost());
		purchaseOrderService.edit(entity.getPurchase().getId(), entity.getPurchase());
	}

	@Override
	protected void resetEntity(PurchaseCost entity) {
		if (entity.getPurchase() != null) {
			PurchaseOrder purchase = purchaseOrderService.findOne(entity.getPurchase().getId());
			purchase.setLocalCost(purchase.getLocalCost() - entity.getLocalCost());
			purchaseOrderService.edit(purchase.getId(), purchase);
		}
	}

}
