package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SaleOrder;
import com.proface.api.mappers.SaleOrderMapper;
import com.proface.api.models.SaleOrderModel;
import com.proface.api.services.ISaleOrderService;

@RestController
@RequestMapping("api/saleOrders")
public class SaleOrderController
		extends ProfaceController<Integer, SaleOrder, SaleOrderModel, SaleOrderMapper, ISaleOrderService> {

}
