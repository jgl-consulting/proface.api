package com.proface.api.services;

import java.util.List;

import com.proface.api.entities.Proveedor;

public interface IProveedorService {

	List<Proveedor> findAll();
	
	void save(Proveedor proveedor);
	
	void delete(Proveedor proveedor);
	
}