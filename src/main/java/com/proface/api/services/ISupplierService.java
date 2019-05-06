package com.proface.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proface.api.entities.Supplier;

public interface ISupplierService {

	Page<Supplier> findAll(Pageable pageable);
	
	Optional<Supplier> findOne(int id);
	
	void save(Supplier supplier);
	
	void edit(int id, Supplier supplier);
	
	void delete(int id);
	
}