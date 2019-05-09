package com.proface.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.proface.api.mappers.IAbstractMapper;
import com.proface.api.services.IAbstractService;

public class BaseRestController<ID, E, M, MP extends IAbstractMapper<M, E>, SV extends IAbstractService<E, ID>> {

	@Autowired
	private SV service;

	@Autowired
	private MP mapper;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody M model) {

		E entity = mapper.convertToEntity(model);

		service.save(entity);

		return new ResponseEntity<>(model, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> list(Pageable pageable) {

		Page<E> list = service.findAll(pageable);

		return new ResponseEntity<>(list.map(entity -> mapper.convertToModel(entity)), HttpStatus.OK);
	}

	@GetMapping("unpaged")
	public ResponseEntity<?> list() {

		List<E> list = service.findAll();

		return new ResponseEntity<>(
				list.stream().map(entity -> mapper.convertToModel(entity)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable ID id) {

		E entity = service.findOne(id);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> edit(@RequestBody M model, @PathVariable ID id) {

		E entity = mapper.convertToEntity(model);

		service.edit(id, entity);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable ID id) {

		service.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public SV getService() {
		return this.service;
	}

	public MP getMapper() {
		return this.mapper;
	}
}
