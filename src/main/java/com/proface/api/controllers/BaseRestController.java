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

/**
 * 
 * @author josec
 * This class abstracts the basic usage of a REST API
 * Supports 4 HttpMethods: GET, POST, PUT, DELETE
 * @param <ID> Primary Key 	Type
 * @param <E>  Entity 		Type
 * @param <M>  Model 		Type
 * @param <MP> Mapper 		Type
 * @param <SV> Service		Type
 */
public class BaseRestController<ID, E, M, MP extends IAbstractMapper<M, E>, SV extends IAbstractService<E, ID>> {

	/**
	 * Injected Entity Service
	 * Must extend IAbstractService Class
	 * Types must be <E, ID>
	 */
	@Autowired
	private SV service;

	/**
	 * Injected Entity-Model Mapper
	 * Must extend IAbstractMapper Class
	 * Types must be <M, E>
	 */
	@Autowired
	private MP mapper;

	/**
	 * Saves an Entity sent as a Model
	 * @param model
	 * @return model with 201
	 */
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody M model) {

		E entity = mapper.convertToEntity(model);

		service.save(entity);

		return new ResponseEntity<>(model, HttpStatus.CREATED);
	}

	/**
	 * Pages Entities as Models 
	 * Param follows the format: page=#pageNumber&size=#pageSize&order=#attribute_#orientation
	 * @param pageable
	 * @return List<model> with 200
	 */
	@GetMapping
	public ResponseEntity<?> list(Pageable pageable) {

		Page<E> list = service.findAll(pageable);

		return new ResponseEntity<>(list.map(entity -> mapper.convertToModel(entity)), HttpStatus.OK);
	}

	/**
	 * Lists Entities as Models
	 * @return List<model> with 200
	 */
	@GetMapping("unpaged")
	public ResponseEntity<?> list() {

		List<E> list = service.findAll();

		return new ResponseEntity<>(
				list.stream().map(entity -> mapper.convertToModel(entity)).collect(Collectors.toList()), HttpStatus.OK);
	}

	/**
	 * Finds an Entity as Model by its ID
	 * @param id
	 * @return model with 200
	 */
	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable ID id) {

		E entity = service.findOne(id);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.OK);
	}

	/**
	 * Modify Entity as Model by its ID
	 * @param model
	 * @param id
	 * @return model with 200
	 */
	@PutMapping("{id}")
	public ResponseEntity<?> edit(@RequestBody M model, @PathVariable ID id) {

		E entity = mapper.convertToEntity(model);

		service.edit(id, entity);

		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	/**
	 * Deletes an Entity by its ID
	 * @param id
	 * @return with 204
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable ID id) {

		service.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns injected Sevice
	 * Usage: If Childrens of this class needs it.
	 * @return
	 */
	protected SV getService() {
		return this.service;
	}

	/**
	 * Returns injected Mapper
	 * Usage: If Childrens of this class needs it.
	 * @return
	 */
	protected MP getMapper() {
		return this.mapper;
	}
}
