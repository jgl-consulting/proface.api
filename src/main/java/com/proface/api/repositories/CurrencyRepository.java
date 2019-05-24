package com.proface.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {

}
