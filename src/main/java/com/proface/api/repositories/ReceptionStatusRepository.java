package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.ReceptionStatus;

@Repository
public interface ReceptionStatusRepository extends PagingAndSortingRepository<ReceptionStatus, Integer>{

	boolean existsByNativeId(String nativeId);
	
}
