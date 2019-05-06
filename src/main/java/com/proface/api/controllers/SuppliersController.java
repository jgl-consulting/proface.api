package com.proface.api.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.proface.api.entities.Supplier;
import com.proface.api.util.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.services.ISuppliersService;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {

	@Autowired
	private ISuppliersService suppliersService;

	private SupplierMapper supplierMapper = SupplierMapper.INSTANCE;

	@GetMapping
	public ResponseEntity<?> listSuppliers(
			@RequestParam Optional<Integer> page,
			@RequestParam Optional<Integer> size,
			@RequestParam Optional<String[]> sortBy,
			@RequestParam(required = false) boolean descending){

		Sort sort = sortBy.map(s -> Sort.by(descending ? Sort.Direction.DESC : Sort.Direction.ASC, s))
				.orElse(Sort.unsorted());
		
		Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(20), sort);

		return ResponseEntity.ok(PageWrapper.of(suppliersService.findAll(pageable), supplierMapper::convertToModel));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {

		return suppliersService.findById(id)
				.map(supplierMapper::convertToModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<?> saveSupplier(@Valid @RequestBody SupplierModel supplierModel) {

		Supplier supplier = supplierMapper.convertToEntity(supplierModel);

		int supplierId = suppliersService.save(supplier);

		return ResponseEntity.created(URI.create("/supplier/" + supplierId)).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateSupplier(@PathVariable int id, @RequestBody SupplierModel supplierModel) {

		Optional<Supplier> supplier = suppliersService.findById(id);

		if(supplier.isPresent()) {
			suppliersService.save(supplierMapper.convertToEntity(supplierModel));

			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int id) {

		Optional<Supplier> supplier = suppliersService.findById(id);

		if(supplier.isPresent()) {
			suppliersService.delete(supplier.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
