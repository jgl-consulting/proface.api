package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.UnitStatus;

@Repository
public interface UnitStatusRepository
		extends PagingAndSortingRepository<UnitStatus, Integer>, JpaSpecificationExecutor<UnitStatus> {

	boolean existsByNativeId(String nativeId);

}
