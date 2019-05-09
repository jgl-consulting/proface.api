package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.SupplierAccount;

@Repository
public interface SupplierAccountRepository extends PagingAndSortingRepository<SupplierAccount, Integer>{
	
	boolean existsByCci(String cci);
	
}
