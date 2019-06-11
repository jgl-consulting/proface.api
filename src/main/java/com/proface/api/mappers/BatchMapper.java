package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Batch;
import com.proface.api.models.BatchModel;

@Mapper(componentModel = "spring")
public interface BatchMapper extends IProfaceMapper<BatchModel, Batch> {

}
