package com.proface.api.controllers;

import com.proface.api.entities.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.services.ISupplierService;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController implements IAbstractRestController<Integer, SupplierModel> {

	@Autowired
	private ISupplierService suppliersService;

	private SupplierMapper supplierMapper = SupplierMapper.INSTANCE;

	public ResponseEntity<?> save(SupplierModel supplierModel) {

		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		suppliersService.save(supplier);

		return new ResponseEntity<>(supplierModel, HttpStatus.CREATED);
	}

	public ResponseEntity<?> list(Pageable pageable) {

		Page<Supplier> suppliers = suppliersService.findAll(pageable);

		return new ResponseEntity<>(suppliers.map(supplier -> supplierMapper.convertToModel(supplier)), HttpStatus.OK);
	}

	public ResponseEntity<?> find(Integer id) {

		Supplier supplier = suppliersService.findOne(id);

		return new ResponseEntity<>(supplierMapper.convertToModel(supplier), HttpStatus.OK);
	}

	public ResponseEntity<?> edit(SupplierModel supplierModel, Integer id) {

		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		suppliersService.edit(id, supplier);

		return new ResponseEntity<>(supplierModel, HttpStatus.OK);
	}
	
	public ResponseEntity<?> delete(Integer id) {

		suppliersService.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
