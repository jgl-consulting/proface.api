package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SupplierContact;
import com.proface.api.models.SupplierContactModel;

@Mapper(componentModel = "Spring")
public interface SupplierContactMapper extends IProfaceMapper<SupplierContactModel, SupplierContact> {

}
