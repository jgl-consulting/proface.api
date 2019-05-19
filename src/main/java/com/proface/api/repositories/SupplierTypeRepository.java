package com.proface.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.SupplierType;

@Repository
public interface SupplierTypeRepository extends PagingAndSortingRepository<SupplierType, Integer> {
	
	Optional<SupplierType> findByName(String name);
	
}
