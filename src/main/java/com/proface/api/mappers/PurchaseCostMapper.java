package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.models.PurchaseCostModel;

@Mapper(componentModel = "spring")
public interface PurchaseCostMapper extends IProfaceMapper<PurchaseCostModel, PurchaseCost> {

}
