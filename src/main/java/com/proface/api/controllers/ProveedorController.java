package com.proface.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Proveedor;
import com.proface.api.mappers.ProveedorMapper;
import com.proface.api.models.ProveedorModel;
import com.proface.api.services.IProveedorService;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;	

	@PostMapping
	public ResponseEntity<?> saveProveedor(@Valid @RequestBody ProveedorModel proveedorModel) {
		Proveedor proveedor = ProveedorMapper.INSTANCE.convertToEntity(proveedorModel);
		proveedorService.save(proveedor);
		return ResponseEntity.ok(proveedor);
	}
	
}
