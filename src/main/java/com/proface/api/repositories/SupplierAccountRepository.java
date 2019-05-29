package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.SupplierAccount;

@Repository
public interface SupplierAccountRepository
		extends PagingAndSortingRepository<SupplierAccount, Integer>, JpaSpecificationExecutor<SupplierAccount> {

	boolean existsByCci(String cci);

}
