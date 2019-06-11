package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository
		extends PagingAndSortingRepository<PurchaseOrder, Integer>, JpaSpecificationExecutor<PurchaseOrder> {

	boolean existsByNativeId(String nativeId);

}
