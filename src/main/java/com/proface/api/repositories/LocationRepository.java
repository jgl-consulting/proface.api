package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Location;

@Repository
public interface LocationRepository
		extends PagingAndSortingRepository<Location, Integer>, JpaSpecificationExecutor<Location> {

	boolean existsByNativeId(String nativeId);

}
