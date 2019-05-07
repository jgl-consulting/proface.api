package com.proface.api.services.impl;

import com.proface.api.entities.Supplier;
import com.proface.api.exceptions.customs.ProfaceDuplicatedIdException;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;

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
	public Supplier findOne(Integer id) {
		Optional<Supplier> supplier = supplierRepository.findById(id);
		if (!supplier.isPresent())
			throw new ProfaceNotExistingException("El proveedor no ha sido registrado anteriormente.");
		return supplier.get();
	}

	@Override
	@Transactional
	public void save(Supplier supplier) {
		supplier.setId(0);
		if (supplierRepository.existsByNativeId(supplier.getNativeId()))
			throw new ProfaceDuplicatedIdException(String.format(
					"El proveedor con identificador %s ya ha sido registrado anteriormente.", supplier.getNativeId()));
		supplierRepository.save(supplier);
	}

	@Override
	@Transactional
	public void edit(Integer id, Supplier supplier) {
		supplier.setId(id);
		if (!supplierRepository.existsById(id))
			throw new ProfaceNotExistingException("El proveedor no ha sido registrado anteriormente.");
		else if (supplierRepository.existsByNativeId(supplier.getNativeId()))
			throw new ProfaceDuplicatedIdException(String.format(
					"El proveedor con identificador %s ya ha sido registrado anteriormente.", supplier.getNativeId()));
		supplierRepository.save(supplier);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		if (!supplierRepository.existsById(id))
			throw new ProfaceNotExistingException("El proveedor no ha sido registrado anteriormente.");
		supplierRepository.deleteById(id);
	}

}
