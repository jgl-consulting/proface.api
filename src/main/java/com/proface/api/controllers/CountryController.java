package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Country;
import com.proface.api.mappers.CountryMapper;
import com.proface.api.models.CountryModel;
import com.proface.api.services.impl.CountryService;

@RestController
@RequestMapping("api/countries")
public class CountryController extends BaseRestController<Integer, Country, CountryModel, CountryMapper, CountryService>{

}
