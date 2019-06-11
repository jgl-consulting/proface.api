package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.mappers.PurchaseOrderMapper;
import com.proface.api.models.PurchaseOrderModel;
import com.proface.api.services.IPurchaseOrderService;

@RestController
@RequestMapping("api/purchaseOrders")
public class PurchaseOrderController extends
		ProfaceController<Integer, PurchaseOrder, PurchaseOrderModel, PurchaseOrderMapper, IPurchaseOrderService> {

}
