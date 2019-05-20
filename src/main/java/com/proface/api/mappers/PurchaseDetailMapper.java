package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.models.PurchaseDetailModel;

@Mapper(componentModel = "spring")
public interface PurchaseDetailMapper extends IAbstractMapper<PurchaseDetailModel, PurchaseDetail> {

}
