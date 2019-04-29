package com.proface.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proface.api.entities.Proveedor;
import com.proface.api.models.ProveedorModel;

@Mapper
public interface ProveedorMapper extends IAbstractMapper<ProveedorModel, Proveedor> {

	ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

	ProveedorModel convertToModel(Proveedor entity);

	Proveedor convertToEntity(ProveedorModel model);
	
}
