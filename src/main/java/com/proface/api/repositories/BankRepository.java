package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.Bank;

@Repository
public interface BankRepository extends PagingAndSortingRepository<Bank, Integer> {

}
