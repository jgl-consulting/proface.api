package com.proface.api.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Product;
import com.proface.api.mappers.ProductMapper;
import com.proface.api.models.ProductModel;
import com.proface.api.reports.ProductReport;
import com.proface.api.services.IProductService;

@RestController
@RequestMapping("api/products")
public class ProductController
		extends ProfaceController<Integer, Product, ProductModel, ProductMapper, IProductService> {

	@Autowired
	private ProductReport reportGenerator;
	
	@GetMapping(value = "reports", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> productReport() {

		List<Product> products = super.getService().findAll();

		ByteArrayInputStream stream = reportGenerator.generateProductReport(products);

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=product_report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(stream));

	}
}
