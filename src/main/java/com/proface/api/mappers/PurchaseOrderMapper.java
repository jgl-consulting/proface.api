package com.proface.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.models.PurchaseOrderModel;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper extends IAbstractMapper<PurchaseOrderModel, PurchaseOrder> {
	
	PurchaseOrderMapper INSTANCE = Mappers.getMapper(PurchaseOrderMapper.class);
	
}
