package com.proface.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Country;
import com.proface.api.repositories.CountryRepository;
import com.proface.api.util.ProfaceConverter;

@RestController
@RequestMapping("api/countries")
public class CountryController {

	@Autowired
	private CountryRepository repository;
	
	@Autowired
	private ProfaceConverter<Country> converter;
	
	@GetMapping
	public ResponseEntity<?> list() {

		List<Country> list = converter.iterableToList(repository.findAll());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
