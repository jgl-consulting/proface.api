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

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.mappers.PurchaseDetailMapper;
import com.proface.api.models.PurchaseDetailModel;
import com.proface.api.services.IPurchaseDetailService;

@RestController
@RequestMapping("api/purchaseDetails")
public class PurchaseDetailController {

	@Autowired
	private IPurchaseDetailService service;

	@Autowired
	private PurchaseDetailMapper mapper;

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
	public ResponseEntity<?> save(@Valid @RequestBody PurchaseDetailModel model) {

		PurchaseDetail entity = mapper.convertToEntity(model);

		service.save(entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> edit(@RequestBody PurchaseDetailModel model, int productId, int purchaseId) {

		PurchaseDetail entity = mapper.convertToEntity(model);

		service.edit(new PurchaseDetailPK(productId, purchaseId), entity);

		return new ResponseEntity<>(mapper.convertToModel(entity), HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<?> delete(int productId, int purchaseId) {

		service.delete(new PurchaseDetailPK(productId, purchaseId));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
