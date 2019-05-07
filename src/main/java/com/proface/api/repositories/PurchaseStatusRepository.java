package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.PurchaseStatus;

@RepositoryRestResource
public interface PurchaseStatusRepository extends PagingAndSortingRepository<PurchaseStatus, Integer> {

}
