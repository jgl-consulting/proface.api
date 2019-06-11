package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.BatchType;

@Repository
public interface BatchTypeRepository
		extends PagingAndSortingRepository<BatchType, Integer>, JpaSpecificationExecutor<BatchType> {

}
