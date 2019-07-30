package com.proface.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.proface.api.entities.SaleDetail;
import com.proface.api.entities.SaleDetailPK;

@Repository
public interface SaleDetailRepository
		extends PagingAndSortingRepository<SaleDetail, SaleDetailPK>, JpaSpecificationExecutor<SaleDetail> {

}
