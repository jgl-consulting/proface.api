package com.proface.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.mappers.PurchaseDetailMapper;
import com.proface.api.models.PurchaseDetailModel;
import com.proface.api.services.IPurchaseDetailService;

@RestController
@RequestMapping("api/purchaseDetails")
public class PurchaseDetailController extends
		BaseRestController<PurchaseDetailPK, PurchaseDetail, PurchaseDetailModel, PurchaseDetailMapper, IPurchaseDetailService> {

	public ResponseEntity<?> delete(PurchaseDetailPK id) {

		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@DeleteMapping("product/{productId}/purchase/{purchaseId}")
	public ResponseEntity<?> delete(@PathVariable int productId, @PathVariable int purchaseId) {

		super.getService().delete(new PurchaseDetailPK(productId, purchaseId));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
