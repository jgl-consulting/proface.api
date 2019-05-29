package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Product;

@Repository
public interface ProductRepository
		extends PagingAndSortingRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	boolean existsByNativeId(String nativeId);

}
