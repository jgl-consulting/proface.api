package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.SaleInvoice;
import com.proface.api.models.SaleInvoiceModel;

@Mapper(componentModel = "spring")
public interface SaleInvoiceMapper extends IProfaceMapper<SaleInvoiceModel, SaleInvoice> {

}
