package com.proface.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proface.api.entities.Supplier;

import java.util.Optional;

public interface ISuppliersService {

	Page<Supplier> findAll(Pageable pageable);

	Optional<Supplier> findById(int id);

	int save(Supplier supplier);
	
	void delete(Supplier supplier);
	
}