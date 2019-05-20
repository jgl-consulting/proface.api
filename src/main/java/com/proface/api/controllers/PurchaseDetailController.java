package com.proface.api.controllers;

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

}
