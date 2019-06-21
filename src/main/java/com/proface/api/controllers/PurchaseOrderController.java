package com.proface.api.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.mappers.PurchaseOrderMapper;
import com.proface.api.models.PurchaseOrderModel;
import com.proface.api.reports.PurchaseOrderReport;
import com.proface.api.services.IPurchaseOrderService;

@RestController
@RequestMapping("api/purchaseOrders")
public class PurchaseOrderController extends
		ProfaceController<Integer, PurchaseOrder, PurchaseOrderModel, PurchaseOrderMapper, IPurchaseOrderService> {

	@Autowired
	private PurchaseOrderReport reportGenerator;
	
	@Override
	public ResponseEntity<?> getReport(Integer id) {
	
		PurchaseOrder purchaseOrder = super.getService().findOne(id);
		
		ByteArrayInputStream stream = reportGenerator.generateReport(purchaseOrder);

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=purchase_report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(stream));
		
	}
	
	@Override
	public ResponseEntity<?> getReport(String filter) {
		
		List<PurchaseOrder> purchases = super.getService().findAll(filter);
		
		ByteArrayInputStream stream = reportGenerator.generateReport(purchases);

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=purchases_report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(stream));
		
	}
}
