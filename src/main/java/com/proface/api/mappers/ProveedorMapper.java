package com.proface.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proface.api.entities.Proveedor;
import com.proface.api.models.ProveedorModel;

@Mapper(componentModel = "spring")
public interface ProveedorMapper extends IAbstractMapper<ProveedorModel, Proveedor> {

	ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);
	
}
