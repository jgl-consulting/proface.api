package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.repositories.PurchaseCostRepository;
import com.proface.api.services.IPurchaseCostService;
import com.proface.api.util.ProfaceCurrencyExchanger;

@Service
public class PurchaseCostService extends ProfaceService<PurchaseCostRepository, PurchaseCost, Integer, Integer>
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
	protected String getEntityName() {
		return PurchaseCost.class.getSimpleName();
	}

	@Override
	protected void prepareEntity(PurchaseCost entity) {
		entity.setLocalCost(ProfaceCurrencyExchanger.fromCurrencyToCurrency(entity.getCurrency().getId(), "PEN",
				entity.getTotalCost()));
	}

}
