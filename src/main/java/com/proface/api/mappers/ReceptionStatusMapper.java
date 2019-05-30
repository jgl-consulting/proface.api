package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.ReceptionStatus;
import com.proface.api.models.ReceptionStatusModel;

@Mapper(componentModel = "spring")
public interface ReceptionStatusMapper extends IProfaceMapper<ReceptionStatusModel, ReceptionStatus>{

}
