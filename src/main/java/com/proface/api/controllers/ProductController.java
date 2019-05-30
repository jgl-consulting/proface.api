package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Product;
import com.proface.api.mappers.ProductMapper;
import com.proface.api.models.ProductModel;
import com.proface.api.services.IProductService;

@RestController
@RequestMapping("api/products")
public class ProductController
		extends ProfaceController<Integer, Product, ProductModel, ProductMapper, IProductService> {

}
