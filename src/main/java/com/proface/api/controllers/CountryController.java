package com.proface.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Country;
import com.proface.api.mappers.CountryMapper;
import com.proface.api.models.CountryModel;
import com.proface.api.services.impl.CountryService;

@RestController
@RequestMapping("api/countries")
public class CountryController
		extends BaseRestController<Integer, Country, CountryModel, CountryMapper, CountryService> {

	@Override
	public ResponseEntity<?> save(CountryModel countryModel) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	public ResponseEntity<?> edit(CountryModel countryModel, Integer id) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

}
