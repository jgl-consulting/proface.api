package com.proface.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Currency;
import com.proface.api.repositories.CurrencyRepository;
import com.proface.api.util.ProfaceConverter;

@RestController
@RequestMapping("api/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyRepository repository;
	
	@Autowired
	private ProfaceConverter<Currency> converter;
	
	@GetMapping
	public ResponseEntity<?> list() {

		List<Currency> list = converter.iterableToList(repository.findAll());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
