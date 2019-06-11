package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Unit;

@Repository
public interface UnitRepository extends PagingAndSortingRepository<Unit, Integer>, JpaSpecificationExecutor<Unit> {

	boolean existsByNativeId(String nativeId);
}
