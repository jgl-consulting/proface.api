package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.ProductLine;

@RepositoryRestResource
public interface ProductLineRepository extends PagingAndSortingRepository<ProductLine, Integer> {

}
