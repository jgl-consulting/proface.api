package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseTrace;
import com.proface.api.repositories.PurchaseTraceRepository;
import com.proface.api.services.IPurchaseTraceService;

@Service
public class PurchaseTraceService extends ProfaceService<PurchaseTraceRepository, PurchaseTrace, Integer, String>
		implements IPurchaseTraceService {

	@Override
	public void save(PurchaseTrace entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, PurchaseTrace entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return PurchaseTrace.class.getSimpleName();
	}

}
