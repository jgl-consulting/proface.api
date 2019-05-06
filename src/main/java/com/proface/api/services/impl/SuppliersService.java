package com.proface.api.services.impl;

import com.proface.api.entities.Supplier;
import com.proface.api.entities.SupplierContact;
import com.proface.api.repositories.SupplierContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.services.ISuppliersService;

import java.util.Optional;

@Service
public class SuppliersService implements ISuppliersService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierContactsRepository supplierContactsRepository;

	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		return supplierRepository.findAll(pageable);
	}

	@Override
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	@Override
	@Transactional
	public int save(Supplier supplier) {

		// Save Contact
		Supplier savedSupplier = supplierRepository.save(supplier);

		for(SupplierContact contact : supplier.getContacts()) {
			contact.setSupplier(savedSupplier);
			supplierContactsRepository.save(contact);
		}

		return savedSupplier.getId();

	}

	@Override
	@Transactional
	public void delete(Supplier supplier) {
		// Eliminando los contactos
		for(SupplierContact contact : supplier.getContacts()) {
			supplierContactsRepository.delete(contact);
		}

		// Eliminando el proveedor
		supplierRepository.delete(supplier);
	}
	
}
