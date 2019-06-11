package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseTrace;

@Repository
public interface PurchaseTraceRepository
		extends PagingAndSortingRepository<PurchaseTrace, Integer>, JpaSpecificationExecutor<PurchaseTrace> {

}
