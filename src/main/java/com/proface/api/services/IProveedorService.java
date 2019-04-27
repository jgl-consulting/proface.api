package com.proface.api.services;

import java.util.List;

import com.proface.api.models.ProveedorModel;

public interface IProveedorService {

	List<ProveedorModel> findAll();
	
	void save(ProveedorModel proveedor);
	
	void delete(ProveedorModel proveedor);
	
}