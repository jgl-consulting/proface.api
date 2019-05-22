package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.ProductLine;
import com.proface.api.mappers.ProductLineMapper;
import com.proface.api.models.ProductLineModel;
import com.proface.api.services.IProductLineService;

@RestController
@RequestMapping("api/productLines")
public class ProductLineController
		extends BaseRestController<Integer, ProductLine, ProductLineModel, ProductLineMapper, IProductLineService> {

}
