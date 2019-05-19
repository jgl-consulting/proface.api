package com.proface.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends PagingAndSortingRepository<PurchaseOrder, Integer> {

	boolean existsByNativeId(String nativeId);
	
	Page<PurchaseOrder> findBySupplierId(Pageable pageable, int supplierId);
	
}
