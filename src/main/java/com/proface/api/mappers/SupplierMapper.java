package com.proface.api.mappers;

import com.proface.api.entities.Supplier;
import org.mapstruct.Mapper;

import com.proface.api.models.SupplierModel;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends IAbstractMapper<SupplierModel, Supplier> {

		Supplier convertToEntity(SupplierModel supplierModel);
}
