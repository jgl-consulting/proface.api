package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.UnitTrace;
import com.proface.api.repositories.UnitTraceRepository;
import com.proface.api.services.IUnitTraceService;

@Service
public class UnitTraceService extends ProfaceService<UnitTraceRepository, UnitTrace, Integer, String>
		implements IUnitTraceService {

	@Override
	public void save(UnitTrace entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, UnitTrace entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return UnitTrace.class.getSimpleName();
	}

}
