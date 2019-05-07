package com.proface.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.mappers.PurchaseOrderMapper;
import com.proface.api.models.PurchaseOrderModel;
import com.proface.api.services.IPurchaseOrderService;

@RestController
@RequestMapping("api/purchaseOrders")
public class PurchaseOrderController implements IAbstractRestController<Integer, PurchaseOrderModel> {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	private PurchaseOrderMapper purchaseOrderMapper = PurchaseOrderMapper.INSTANCE;

	public ResponseEntity<?> save(PurchaseOrderModel purchaseOrderModel) {

		PurchaseOrder purchaseOrder = purchaseOrderMapper.convertToEntity(purchaseOrderModel);

		purchaseOrderService.save(purchaseOrder);

		return new ResponseEntity<>(purchaseOrderModel, HttpStatus.CREATED);
	}

	public ResponseEntity<?> list(Pageable pageable) {

		Page<PurchaseOrder> purchaseOrders = purchaseOrderService.findAll(pageable);

		return new ResponseEntity<>(purchaseOrders.map(purchase -> purchaseOrderMapper.convertToModel(purchase)),
				HttpStatus.OK);
	}

	public ResponseEntity<?> find(Integer id) {

		PurchaseOrder purchaseOrder = purchaseOrderService.findOne(id);

		return  new ResponseEntity<>(purchaseOrderMapper.convertToModel(purchaseOrder), HttpStatus.OK);
	}
	
	public ResponseEntity<?> edit(PurchaseOrderModel purchaseOrderModel, Integer id) {
			
		PurchaseOrder purchaseOrder = purchaseOrderMapper.convertToEntity(purchaseOrderModel);
		
		purchaseOrderService.edit(id, purchaseOrder);
		
		return new ResponseEntity<>(purchaseOrderModel, HttpStatus.OK);		
	}
	
	public ResponseEntity<?> delete(Integer id) {
				
		purchaseOrderService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}

}
