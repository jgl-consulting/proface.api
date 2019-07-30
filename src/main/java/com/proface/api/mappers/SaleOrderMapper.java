package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SaleOrder;
import com.proface.api.models.SaleOrderModel;

@Mapper(componentModel = "spring")
public interface SaleOrderMapper extends IProfaceMapper<SaleOrderModel, SaleOrder> {

}
