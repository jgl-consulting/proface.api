package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.BatchType;
import com.proface.api.repositories.BatchTypeRepository;
import com.proface.api.services.IBatchTypeService;

@Service
public class BatchTypeService extends ProfaceService<BatchTypeRepository, BatchType, Integer, String>
		implements IBatchTypeService {

	@Override
	public void save(BatchType entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, BatchType entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return BatchType.class.getSimpleName();
	}

}
