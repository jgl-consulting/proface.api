package com.proface.api.services.impl;

import com.proface.api.entities.Supplier;import com.proface.api.entities.SupplierType;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.repositories.SupplierTypeRepository;
import com.proface.api.services.ISupplierService;

@Service
public class SupplierService extends BaseService<SupplierRepository, Supplier, Integer, String>
		implements ISupplierService {

	@Autowired
	private SupplierTypeRepository supplierTypeRepository;
	
	@Override
	public void save(Supplier entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		getTypeByCountry(entity);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Supplier entity) {
		entity.setId(id);
		getTypeByCountry(entity);
		super.edit(id, entity);
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(Supplier entity, Supplier repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}

	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}
	
	private void getTypeByCountry(Supplier supplier) {
		if (supplier.getCountry() != null) {
			if (supplier.getCountry().getId() == 161) {
				Optional<SupplierType> type = supplierTypeRepository.findByName("Nacional");
				supplier.setType(type.isPresent() ? type.get() : null);
			} else {
				Optional<SupplierType> type = supplierTypeRepository.findByName("Internacional");
				supplier.setType(type.isPresent() ? type.get() : null);
			}
		}
	}

}
