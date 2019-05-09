package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.ProductLine;

@Repository
public interface ProductLineRepository extends PagingAndSortingRepository<ProductLine, Integer> {

}
