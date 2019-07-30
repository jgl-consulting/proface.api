package com.proface.api.controllers;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SaleDetail;
import com.proface.api.entities.SaleDetailPK;
import com.proface.api.mappers.SaleDetailMapper;
import com.proface.api.models.SaleDetailModel;
import com.proface.api.services.ISaleDetailService;

@RestController
@RequestMapping("api/saleDetails")
public class SaleDetailController {

	@Autowired
	private ISaleDetailService service;

	@Autowired
	private SaleDetailMapper mapper;

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

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody SaleDetailModel model) {

		SaleDetail entity = mapper.convertToEntity(model);

		service.save(entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> edit(@RequestBody SaleDetailModel model, int productId, int saleId) {

		SaleDetail entity = mapper.convertToEntity(model);

		service.edit(new SaleDetailPK(productId, saleId), entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<?> delete(int productId, int saleId) {

		service.delete(new SaleDetailPK(productId, saleId));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
