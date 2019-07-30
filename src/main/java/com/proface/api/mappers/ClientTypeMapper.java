package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.ClientType;
import com.proface.api.models.ClientTypeModel;

@Mapper(componentModel = "spring")
public interface ClientTypeMapper extends IProfaceMapper<ClientTypeModel, ClientType> {

}
