package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Batch;

@Repository
public interface BatchRepository extends PagingAndSortingRepository<Batch, Integer>, JpaSpecificationExecutor<Batch> {

	boolean existsByNativeId(String nativeId);
	
}
