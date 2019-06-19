package com.proface.api.controllers;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.proface.api.mappers.IProfaceMapper;
import com.proface.api.services.IProfaceService;

/**
 * 
 * @author josec This class abstracts the basic usage of a REST API Supports 4
 *         HttpMethods: GET, POST, PUT, DELETE
 * @param <ID>
 *            Primary Key Type
 * @param <E>
 *            Entity Type
 * @param <M>
 *            Model Type
 * @param <MP>
 *            Mapper Type
 * @param <SV>
 *            Service Type
 */
public class ProfaceController<ID, E, M, MP extends IProfaceMapper<M, E>, SV extends IProfaceService<E, ID>> {

	/**
	 * Injected Entity Service Must extend IAbstractService Class Types must be <E,
	 * ID>
	 */
	@Autowired
	private SV service;

	/**
	 * Injected Entity-Model Mapper Must extend IAbstractMapper Class Types must be
	 * <M, E>
	 */
	@Autowired
	private MP mapper;

	/**
	 * Saves an Entity sent as a Model
	 * 
	 * @param model
	 * @return model with 201
	 */
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody M model) {

		E entity = mapper.convertToEntity(model);

		service.save(entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.CREATED);
	}

	/**
	 * Pages Entities as Models Param follows the format:
	 * page=#pageNumber&size=#pageSize&order=#attribute_#orientation
	 * 
	 * @param pageable
	 * @return List<model> with 200
	 */
	@GetMapping
	public ResponseEntity<?> list(String filter, Pageable pageable, boolean unpaged) {

		if (filter != null) {
			if (!unpaged) {
				return new ResponseEntity<>(service.findAll(filter, pageable).map(e -> mapper.convertToModel(e)),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(service.findAll(filter).stream().map(e -> mapper.convertToModel(e))
						.collect(Collectors.toList()), HttpStatus.OK);
			}
		} else {
			if (!unpaged) {
				return new ResponseEntity<>(service.findAll(pageable).map(e -> mapper.convertToModel(e)),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(
						service.findAll().stream().map(e -> mapper.convertToModel(e)).collect(Collectors.toList()),
						HttpStatus.OK);
			}
		}

	}

	/**
	 * Finds an Entity as Model by its ID
	 * 
	 * @param id
	 * @return model with 200
	 */
	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable ID id) {

		return new ResponseEntity<>(mapper.convertToModel(service.findOne(id)), HttpStatus.OK);
	}

	/**
	 * Modify Entity as Model by its ID
	 * 
	 * @param model
	 * @param id
	 * @return model with 200
	 */
	@PutMapping("{id}")
	public ResponseEntity<?> edit(@PathVariable ID id, @RequestBody M model) {

		E entity = mapper.convertToEntity(model);

		service.edit(id, entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.OK);
	}

	/**
	 * Deletes an Entity by its ID
	 * 
	 * @param id
	 * @return with 204
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable ID id) {

		service.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns Pdf Report List from Filter
	 * @param filter
	 * @return
	 */
	@GetMapping(value = "reports", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> getReport(String filter) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns Pdf Report from ID
	 * @param id
	 * @return
	 */
	@GetMapping(value = "reports/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> getReport(@PathVariable ID id) {
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns injected Sevice Usage: If Childrens of this class needs it.
	 * 
	 * @return
	 */
	protected SV getService() {
		return this.service;
	}

	/**
	 * Returns injected Mapper Usage: If Childrens of this class needs it.
	 * 
	 * @return
	 */
	protected MP getMapper() {
		return this.mapper;
	}
}
