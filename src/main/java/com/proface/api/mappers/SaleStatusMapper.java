package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SaleStatus;
import com.proface.api.models.SaleStatusModel;

@Mapper(componentModel = "spring")
public interface SaleStatusMapper extends IProfaceMapper<SaleStatusModel, SaleStatus> {

}
