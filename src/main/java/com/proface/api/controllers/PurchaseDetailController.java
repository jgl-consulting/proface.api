package com.proface.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		ProfaceController<PurchaseDetailPK, PurchaseDetail, PurchaseDetailModel, PurchaseDetailMapper, IPurchaseDetailService> {

	public ResponseEntity<?> delete(PurchaseDetailPK id) {

		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	public ResponseEntity<?> edit(PurchaseDetailModel model, PurchaseDetailPK id) {

		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PutMapping
	public ResponseEntity<?> edit(@RequestBody PurchaseDetailModel model, int productId, int purchaseId) {

		PurchaseDetail entity = super.getMapper().convertToEntity(model);

		super.getService().edit(new PurchaseDetailPK(productId, purchaseId), entity);

		return new ResponseEntity<>(model, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<?> delete(int productId, int purchaseId) {

		super.getService().delete(new PurchaseDetailPK(productId, purchaseId));

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
