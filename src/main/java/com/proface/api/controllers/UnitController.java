package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Unit;
import com.proface.api.mappers.UnitMapper;
import com.proface.api.models.UnitModel;
import com.proface.api.services.IUnitService;

@RestController
@RequestMapping("api/units")
public class UnitController extends ProfaceController<Integer, Unit, UnitModel, UnitMapper, IUnitService> {

}
