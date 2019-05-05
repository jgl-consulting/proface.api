package com.proface.api.services.impl;

import java.util.List;

import com.proface.api.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.services.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> findAll() {
		return null;
	}

	@Override
	@Transactional
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	public void delete(Supplier supplier) {
		supplierRepository.delete(supplier);
	}
	
}
