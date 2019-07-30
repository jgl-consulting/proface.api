package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SaleStatus;
import com.proface.api.mappers.SaleStatusMapper;
import com.proface.api.models.SaleStatusModel;
import com.proface.api.services.ISaleStatusService;

@RestController
@RequestMapping("api/saleStatuses")
public class SaleStatusController
		extends ProfaceController<Integer, SaleStatus, SaleStatusModel, SaleStatusMapper, ISaleStatusService> {

}
