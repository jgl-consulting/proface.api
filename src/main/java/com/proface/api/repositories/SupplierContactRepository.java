package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.proface.api.entities.SupplierContact;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierContactRepository extends PagingAndSortingRepository<SupplierContact, Integer> {

}
