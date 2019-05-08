package com.proface.api.controllers;

import com.proface.api.entities.Supplier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.services.ISupplierService;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController
		extends BaseRestController<Integer, Supplier, SupplierModel, SupplierMapper, ISupplierService> {

}
