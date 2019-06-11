package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.UnitStatus;
import com.proface.api.mappers.UnitStatusMapper;
import com.proface.api.models.UnitStatusModel;
import com.proface.api.services.IUnitStatusService;

@RestController
@RequestMapping("api/unitStatuses")
public class UnitStatusController
		extends ProfaceController<Integer, UnitStatus, UnitStatusModel, UnitStatusMapper, IUnitStatusService> {

}
