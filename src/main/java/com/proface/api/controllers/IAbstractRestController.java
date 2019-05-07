package com.proface.api.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAbstractRestController<ID, M> {

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody M model);
	
	@GetMapping
	public ResponseEntity<?> list(Pageable pageable);
	
	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable ID id);
	
	@PutMapping("{id}")
	public ResponseEntity<?> edit(@RequestBody M model, @PathVariable ID id);
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable ID id);
	
}
