package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.SupplierType;

@RepositoryRestResource
public interface SupplierTypeRepository extends PagingAndSortingRepository<SupplierType, Integer> {
	
}
