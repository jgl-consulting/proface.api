package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.SupplierAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierAccountRepository extends PagingAndSortingRepository<SupplierAccount, Integer>{

}
