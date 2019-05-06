package com.proface.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proface.api.entities.Product;
import com.proface.api.models.ProductModel;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IAbstractMapper<ProductModel, Product> {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
}
