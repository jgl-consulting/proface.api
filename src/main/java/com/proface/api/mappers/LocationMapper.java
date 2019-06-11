package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Location;
import com.proface.api.models.LocationModel;

@Mapper(componentModel = "spring")
public interface LocationMapper extends IProfaceMapper<LocationModel, Location> {

}
