package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SaleInvoice;
import com.proface.api.mappers.SaleInvoiceMapper;
import com.proface.api.models.SaleInvoiceModel;
import com.proface.api.services.ISaleInvoiceService;

@RestController
@RequestMapping("api/saleInvoices")
public class SaleInvoiceController
		extends ProfaceController<Integer, SaleInvoice, SaleInvoiceModel, SaleInvoiceMapper, ISaleInvoiceService> {

}
