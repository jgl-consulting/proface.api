package com.proface.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.mappers.PurchaseOrderMapper;
import com.proface.api.models.PurchaseOrderModel;
import com.proface.api.services.IPurchaseOrderService;

@RestController
@RequestMapping("api/purchaseOrders")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService purchaseOrderService;

	private PurchaseOrderMapper purchaseOrderMapper = PurchaseOrderMapper.INSTANCE;

	@PostMapping
	public ResponseEntity<?> savePurchaseOrder(@Valid @RequestBody PurchaseOrderModel purchaseOrderModel) {

		PurchaseOrder purchaseOrder = purchaseOrderMapper.convertToEntity(purchaseOrderModel);

		purchaseOrderService.save(purchaseOrder);

		return new ResponseEntity<>(purchaseOrderModel, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<?> listPurchaseOrders(Pageable pageable) {

		Page<PurchaseOrder> purchaseOrders = purchaseOrderService.findAll(pageable);

		return new ResponseEntity<>(purchaseOrders.map(purchase -> purchaseOrderMapper.convertToModel(purchase)),
				HttpStatus.OK);

	}

	@GetMapping("{id}")
	public ResponseEntity<?> findPurchaseOrder(@PathVariable int id) {

		Optional<PurchaseOrder> purchaseOrder = purchaseOrderService.findOne(id);

		return purchaseOrder.isPresent()
				? new ResponseEntity<>(purchaseOrderMapper.convertToModel(purchaseOrder.get()), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> editPurchaseOrder(@RequestBody PurchaseOrderModel purchaseOrderModel, @PathVariable int id) {
		
		if(!purchaseOrderService.exists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		PurchaseOrder purchaseOrder = purchaseOrderMapper.convertToEntity(purchaseOrderModel);
		
		purchaseOrderService.edit(id, purchaseOrder);
		
		return new ResponseEntity<>(purchaseOrderModel, HttpStatus.OK);		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletePurchaseOrder(@PathVariable int id) {
		
		if(!purchaseOrderService.exists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		purchaseOrderService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
