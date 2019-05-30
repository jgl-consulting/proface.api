package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.ProductLine;
import com.proface.api.models.ProductLineModel;

@Mapper(componentModel = "spring")
public interface ProductLineMapper extends IProfaceMapper<ProductLineModel, ProductLine> {

}
