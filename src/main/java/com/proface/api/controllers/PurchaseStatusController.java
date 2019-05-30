package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseStatus;
import com.proface.api.mappers.PurchaseStatusMapper;
import com.proface.api.models.PurchaseStatusModel;
import com.proface.api.services.impl.PurchaseStatusService;

@RestController
@RequestMapping("api/purchaseStatuses")
public class PurchaseStatusController extends
		ProfaceController<Integer, PurchaseStatus, PurchaseStatusModel, PurchaseStatusMapper, PurchaseStatusService> {

}
