package com.proface.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseStatus;

@Repository
public interface PurchaseStatusRepository extends PagingAndSortingRepository<PurchaseStatus, Integer> {

	boolean existsByNativeId(String nativeId);
	
	Optional<PurchaseStatus> findByNativeId(String nativeId);
	
}
