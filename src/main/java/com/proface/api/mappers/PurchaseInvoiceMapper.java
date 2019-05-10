package com.proface.api.mappers;

import org.mapstruct.Mapper;

import com.proface.api.entities.PurchaseInvoice;
import com.proface.api.models.PurchaseInvoiceModel;

@Mapper(componentModel = "spring")
public interface PurchaseInvoiceMapper extends IAbstractMapper<PurchaseInvoiceModel, PurchaseInvoice> {

}
