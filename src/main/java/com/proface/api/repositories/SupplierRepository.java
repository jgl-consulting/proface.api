package com.proface.api.repositories;

import com.proface.api.entities.Supplier;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository
		extends PagingAndSortingRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {

	boolean existsByNativeId(String nativeId);

}
