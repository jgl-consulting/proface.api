package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.PurchaseInvoice;

@RepositoryRestResource
public interface PurchaseInvoiceRepository extends PagingAndSortingRepository<PurchaseInvoice, Integer> {

}
