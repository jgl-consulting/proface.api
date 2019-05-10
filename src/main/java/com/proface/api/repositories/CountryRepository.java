package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {

}
