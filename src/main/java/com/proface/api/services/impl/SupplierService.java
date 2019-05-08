package com.proface.api.services.impl;

import com.proface.api.entities.Supplier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.services.ISupplierService;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class SupplierService extends ProfaceValidationHelper<String> implements ISupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		return supplierRepository.findAll(pageable);
	}

	@Override
	public Supplier findOne(Integer id) {
		Optional<Supplier> entity = supplierRepository.findById(id);
		notExisting(id);
		return entity.get();
	}

	@Override
	@Transactional
	public void save(Supplier entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		supplierRepository.save(entity);
	}

	@Override
	@Transactional
	public void edit(Integer id, Supplier entity) {
		entity.setId(id);
		notExisting(id);
		duplicatedId(entity.getNativeId());
		supplierRepository.save(entity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		notExisting(id);
		supplierRepository.deleteById(id);
	}
	
	protected void duplicatedId(String nativeId) {
		if (supplierRepository.existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	protected void notExisting(int id) {
		if (!supplierRepository.existsById(id))
			super.notExisting();
	}
	
	protected String getEntityName() {
		return "El Proveedor";
	}

}
