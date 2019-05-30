package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Country;
import com.proface.api.models.CountryModel;

@Mapper(componentModel = "spring")
public interface CountryMapper extends IProfaceMapper<CountryModel, Country> {

}
