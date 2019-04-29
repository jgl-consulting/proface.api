package com.proface.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.mappers.ProveedorMapper;
import com.proface.api.models.ProveedorModel;
import com.proface.api.repositories.ProveedorRepository;
import com.proface.api.services.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<ProveedorModel> findAll() {
		return null;
	}

	@Override
	public void save(ProveedorModel proveedor) {
		proveedorRepository.save(ProveedorMapper.INSTANCE.convertToEntity(proveedor));
	}

	@Override
	public void delete(ProveedorModel proveedor) {
		proveedorRepository.delete(ProveedorMapper.INSTANCE.convertToEntity(proveedor));
	}
	
}
