package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SupplierType;
import com.proface.api.mappers.SupplierTypeMapper;
import com.proface.api.models.SupplierTypeModel;
import com.proface.api.services.ISupplierTypeService;

@RestController
@RequestMapping("api/supplierTypes")
public class SupplierTypeController
		extends BaseRestController<Integer, SupplierType, SupplierTypeModel, SupplierTypeMapper, ISupplierTypeService> {

}
