package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.BatchType;
import com.proface.api.models.BatchTypeModel;

@Mapper(componentModel = "spring")
public interface BatchTypeMapper extends IProfaceMapper<BatchTypeModel, BatchType> {

}
