package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleTrace;
import com.proface.api.repositories.SaleTraceRepository;
import com.proface.api.services.ISaleTraceService;

@Service
public class SaleTraceService extends ProfaceService<SaleTraceRepository, SaleTrace, Integer, String>
		implements ISaleTraceService {

	@Override
	public void save(SaleTrace entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SaleTrace entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleTrace.class.getSimpleName();
	}
}
