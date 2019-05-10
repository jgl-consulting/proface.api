package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.Bank;
import com.proface.api.models.BankModel;

@Mapper(componentModel = "spring")
public interface BankMapper extends IAbstractMapper<BankModel, Bank> {

}
