package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.BatchType;
import com.proface.api.mappers.BatchTypeMapper;
import com.proface.api.models.BatchTypeModel;
import com.proface.api.services.IBatchTypeService;

@RestController
@RequestMapping("api/batchTypes")
public class BatchTypeController
		extends ProfaceController<Integer, BatchType, BatchTypeModel, BatchTypeMapper, IBatchTypeService> {

}
