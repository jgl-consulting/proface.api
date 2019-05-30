package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.PurchaseStatus;
import com.proface.api.models.PurchaseStatusModel;

@Mapper(componentModel = "spring")
public interface PurchaseStatusMapper extends IProfaceMapper<PurchaseStatusModel, PurchaseStatus> {

}
