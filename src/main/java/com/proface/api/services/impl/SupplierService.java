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

@Service
public class SupplierService implements ISupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		return supplierRepository.findAll(pageable);
	}
	
	@Override
	public Optional<Supplier> findOne(int id) {
		return supplierRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	@Transactional
	public void edit(int id, Supplier supplier) {
		supplier.setId(id);		
		supplierRepository.save(supplier);
	}

	@Override
	@Transactional
	public void delete(int id) {
		supplierRepository.deleteById(id);
	}
	
}
