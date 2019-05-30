package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SupplierAccount;
import com.proface.api.models.SupplierAccountModel;

@Mapper(componentModel = "spring")
public interface SupplierAccountMapper extends IProfaceMapper<SupplierAccountModel, SupplierAccount> {

}
