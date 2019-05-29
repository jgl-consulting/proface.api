package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;

@Repository
public interface PurchaseDetailRepository
		extends PagingAndSortingRepository<PurchaseDetail, PurchaseDetailPK>, JpaSpecificationExecutor<PurchaseDetail> {

}
