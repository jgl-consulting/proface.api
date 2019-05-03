package com.proface.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.entities.Proveedor;
import com.proface.api.repositories.ProveedorRepository;
import com.proface.api.services.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> findAll() {
		return null;
	}

	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}

	@Override
	public void delete(Proveedor proveedor) {
		proveedorRepository.delete(proveedor);
	}
	
}
