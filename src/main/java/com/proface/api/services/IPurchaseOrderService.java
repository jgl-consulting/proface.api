package com.proface.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proface.api.entities.PurchaseOrder;

public interface IPurchaseOrderService extends IAbstractService<PurchaseOrder, Integer> {

	Page<PurchaseOrder> findAll(Pageable pageable, int supplierId);

}
