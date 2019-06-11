package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Unit;
import com.proface.api.models.UnitModel;

@Mapper(componentModel = "spring")
public interface UnitMapper extends IProfaceMapper<UnitModel, Unit> {

}
