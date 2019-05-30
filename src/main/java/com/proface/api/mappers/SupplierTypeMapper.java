package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SupplierType;
import com.proface.api.models.SupplierTypeModel;

@Mapper(componentModel = "spring")
public interface SupplierTypeMapper extends IProfaceMapper<SupplierTypeModel, SupplierType>{

}
