package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.PurchaseCost;
import com.proface.api.mappers.PurchaseCostMapper;
import com.proface.api.models.PurchaseCostModel;
import com.proface.api.services.IPurchaseCostService;

@RestController
@RequestMapping("api/purchaseCosts")
public class PurchaseCostController
		extends ProfaceController<Integer, PurchaseCost, PurchaseCostModel, PurchaseCostMapper, IPurchaseCostService> {

}
