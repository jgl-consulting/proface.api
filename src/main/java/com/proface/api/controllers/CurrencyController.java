package com.proface.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Currency;

@RestController
@RequestMapping("api/currencies")
public class CurrencyController {

	@GetMapping("unpaged")
	public ResponseEntity<?> list() {

		Currency[] array = { new Currency("PEN", "Soles"), new Currency("USD", "Dólares") };

		List<Currency> list = Arrays.asList(array);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
