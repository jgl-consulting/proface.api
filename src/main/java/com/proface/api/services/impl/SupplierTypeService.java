package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SupplierType;
import com.proface.api.repositories.SupplierTypeRepository;
import com.proface.api.services.ISupplierTypeService;

@Service
public class SupplierTypeService extends BaseService<SupplierTypeRepository, SupplierType, Integer, Integer>
		implements ISupplierTypeService {

	@Override
	public void save(SupplierType entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SupplierType entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	protected String getEntityName() {
		return SupplierType.class.getSimpleName();
	}

}
