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
		if(proveedorRepository.existsById(proveedor.getIdProveedor()))
			throwIdException(proveedor.getIdProveedor());
		if(proveedor.getContacto() != null) {
			proveedor.getContacto().setIdProveedor(proveedor);
			proveedor.getContacto().setIdContacto(proveedor.getIdProveedor());
		}
		if(proveedor.getCuenta() != null) {
			proveedor.getCuenta().setIdProveedor(proveedor);
		}
		if(proveedor.getDireccion() != null) {
			proveedor.getDireccion().setIdProveedor(proveedor);
		}
		//TODO: Guardar en Cadena
		proveedorRepository.save(proveedor);
	}

	@Override
	public void delete(Proveedor proveedor) {
		proveedorRepository.delete(proveedor);
	}
	
	private void throwIdException(String idProveedor) {
		String errorMessage = String.format("El proveedor con id %s ya ha sido registrado anteriormente.", idProveedor);
		throw new RuntimeException(errorMessage);
	}
	
}
