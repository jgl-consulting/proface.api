package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SaleDetail;
import com.proface.api.models.SaleDetailModel;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper extends IProfaceMapper<SaleDetailModel, SaleDetail> {

}
