package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseInvoice;
import com.proface.api.mappers.PurchaseInvoiceMapper;
import com.proface.api.models.PurchaseInvoiceModel;
import com.proface.api.services.IPurchaseInvoiceService;

@RestController
@RequestMapping("api/purchaseInvoices")
public class PurchaseInvoiceController extends
		ProfaceController<Integer, PurchaseInvoice, PurchaseInvoiceModel, PurchaseInvoiceMapper, IPurchaseInvoiceService> {

}
