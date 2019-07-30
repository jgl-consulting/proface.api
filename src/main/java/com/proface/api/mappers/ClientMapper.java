package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Client;
import com.proface.api.models.ClientModel;

@Mapper(componentModel = "spring")
public interface ClientMapper extends IProfaceMapper<ClientModel, Client> {

}
