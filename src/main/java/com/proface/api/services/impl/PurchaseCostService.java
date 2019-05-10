package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.repositories.PurchaseCostRepository;
import com.proface.api.services.IPurchaseCostService;

@Service
public class PurchaseCostService extends BaseService<PurchaseCostRepository, PurchaseCost, Integer, Integer>
		implements IPurchaseCostService {

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
	protected void compareEntity(PurchaseCost entity, PurchaseCost repositoryEntity) {
		if (entity.getDescription() == null)
			entity.setDescription(repositoryEntity.getDescription());
		if (entity.getPurchase() == null)
			entity.setPurchase(repositoryEntity.getPurchase());
	}

	@Override
	protected String getEntityName() {
		return PurchaseCost.class.getSimpleName();
	}
	
}
