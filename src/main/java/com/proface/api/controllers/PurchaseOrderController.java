package com.proface.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.mappers.PurchaseOrderMapper;
import com.proface.api.models.PurchaseOrderModel;
import com.proface.api.services.IPurchaseOrderService;

@RestController
@RequestMapping("api/purchaseOrders")
public class PurchaseOrderController extends
		BaseRestController<Integer, PurchaseOrder, PurchaseOrderModel, PurchaseOrderMapper, IPurchaseOrderService> {

	@GetMapping("/supplier/{supplierId}")
	public ResponseEntity<?> list(Pageable pageable, @PathVariable int supplierId) {

		Page<PurchaseOrder> list = super.getService().findAll(pageable, supplierId);
		Page<PurchaseOrderModel> pageModel = list.map(entity -> super.getMapper().convertToModel(entity));
		return new ResponseEntity<>(pageModel, HttpStatus.OK);
	}
	
}
