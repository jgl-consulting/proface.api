package com.proface.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.proface.api.entities.Proveedor;
import com.proface.api.models.ProveedorModel;

@Mapper(componentModel = "spring")
public interface ProveedorMapper extends IAbstractMapper<ProveedorModel, Proveedor> {

	ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

	//TODO: Intentar mapear los modelos
	@Mappings({
		@Mapping(target = "contacto", source = "contacto"),
		@Mapping(target = "cuenta", source = "cuenta"),
		@Mapping(target = "direccion", source = "direccion")
	})
	Proveedor convertToEntity(ProveedorModel model);
}
