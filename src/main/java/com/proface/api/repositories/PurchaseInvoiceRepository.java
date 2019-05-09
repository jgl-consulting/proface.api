package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseInvoice;

@Repository
public interface PurchaseInvoiceRepository extends PagingAndSortingRepository<PurchaseInvoice, Integer> {

	boolean existsByNativeId(String nativeId);
	
}
