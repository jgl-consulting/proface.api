package com.proface.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proface.api.entities.Product;

public interface IProductService extends IAbstractService<Product, Integer> {

	Page<Product> search(String search, Pageable pageable);
	
}
