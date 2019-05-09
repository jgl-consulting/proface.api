package com.proface.api.services.impl;

import com.proface.api.entities.Supplier;

import org.springframework.stereotype.Service;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.services.ISupplierService;

@Service
public class SupplierService extends BaseService<SupplierRepository, Supplier, Integer, String>
		implements ISupplierService {

	@Override
	public void save(Supplier entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Supplier entity) {
		entity.setId(id);
		super.edit(id, entity);
	}
	
	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}
	
	@Override
	protected void compareEntity(Supplier entity, Supplier repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else
			entity.setNativeId(repositoryEntity.getNativeId());
	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}

}
