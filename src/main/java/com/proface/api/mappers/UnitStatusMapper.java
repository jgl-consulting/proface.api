package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.UnitStatus;
import com.proface.api.models.UnitStatusModel;

@Mapper(componentModel = "spring")
public interface UnitStatusMapper extends IProfaceMapper<UnitStatusModel, UnitStatus> {

}
