package com.proface.api.services;

import java.util.List;

import com.proface.api.entities.Supplier;

public interface ISuppliersService {

	List<Supplier> findAll();
	
	void save(Supplier supplier);
	
	void delete(Supplier supplier);
	
}