package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleStatus;
import com.proface.api.repositories.SaleStatusRepository;
import com.proface.api.services.ISaleStatusService;

@Service
public class SaleStatusService extends ProfaceService<SaleStatusRepository, SaleStatus, Integer, String>
		implements ISaleStatusService {

	@Override
	public void save(SaleStatus entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SaleStatus entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleStatus.class.getSimpleName();
	}

}
