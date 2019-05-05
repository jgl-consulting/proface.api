package com.proface.api.mappers;

import com.proface.api.entities.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proface.api.models.SupplierModel;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends IAbstractMapper<SupplierModel, Supplier> {

	SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
	
}
