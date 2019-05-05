package com.proface.api.controllers;

import javax.validation.Valid;

import com.proface.api.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.services.IProveedorService;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {

	@Autowired
	private IProveedorService proveedorService;	

	private SupplierMapper supplierMapper = SupplierMapper.INSTANCE;

	@PostMapping
	public ResponseEntity<?> saveSupplier(@Valid @RequestBody SupplierModel supplierModel) {

		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		proveedorService.save(supplier);

		return ResponseEntity.ok(supplier);
	}
	
}
