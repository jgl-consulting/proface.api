package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseCost;

@Repository
public interface PurchaseCostInterface extends PagingAndSortingRepository<PurchaseCost, Integer> {

}
