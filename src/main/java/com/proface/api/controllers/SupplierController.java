package com.proface.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.proface.api.entities.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.services.ISupplierService;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {

	@Autowired
	private ISupplierService suppliersService;

	private SupplierMapper supplierMapper = SupplierMapper.INSTANCE;

	@PostMapping
	public ResponseEntity<?> saveSupplier(@Valid @RequestBody SupplierModel supplierModel) {

		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		suppliersService.save(supplier);

		return new ResponseEntity<>(supplierModel, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> listSuppliers(Pageable pageable) {
		
		Page<Supplier> suppliers = suppliersService.findAll(pageable);
		
		return new ResponseEntity<>(suppliers.map(supplier -> supplierMapper.convertToModel(supplier)), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findSupplier(@PathVariable int id) {
		
		Optional<Supplier> supplier = suppliersService.findOne(id);
		
		return supplier.isPresent() ? new ResponseEntity<>(supplierMapper.convertToModel(supplier.get()), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> editSupplier(@RequestBody SupplierModel supplierModel, @PathVariable int id) {
		
		if(!suppliersService.findOne(id).isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		suppliersService.edit(id, supplier);

		return new ResponseEntity<>(supplierModel, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int id) {

		if(!suppliersService.findOne(id).isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		suppliersService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
