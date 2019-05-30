package com.proface.api.mappers;

import com.proface.api.entities.Supplier;
import org.mapstruct.Mapper;

import com.proface.api.models.SupplierModel;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends IProfaceMapper<SupplierModel, Supplier> {

}
