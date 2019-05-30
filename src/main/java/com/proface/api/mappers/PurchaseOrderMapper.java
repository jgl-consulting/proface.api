package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.models.PurchaseOrderModel;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper extends IProfaceMapper<PurchaseOrderModel, PurchaseOrder> {
	
}
