package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Country;
import com.proface.api.repositories.CountryRepository;
import com.proface.api.services.ICountryService;

@Service
public class CountryService extends BaseService<CountryRepository, Country, Integer, Integer>
		implements ICountryService {

	@Override
	public void save(Country entity) {
	}
	
	@Override
	public void edit(Integer id, Country entity) {
	}
	
	@Override
	public void delete(Integer id) {
	}
	
	@Override
	protected String getEntityName() {
		return Country.class.getSimpleName();
	}
	
}
