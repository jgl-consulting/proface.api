package com.proface.api.controllers;

import com.proface.api.entities.Supplier;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.mappers.SupplierMapper;
import com.proface.api.models.SupplierModel;
import com.proface.api.reports.SupplierReport;
import com.proface.api.services.ISupplierService;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController
		extends ProfaceController<Integer, Supplier, SupplierModel, SupplierMapper, ISupplierService> {

	@Autowired
	private SupplierReport reportGenerator;
	
	@Override
	public ResponseEntity<?> getReport(String filter) {

		List<Supplier> suppliers = super.getService().findAll(filter);

		ByteArrayInputStream stream = reportGenerator.generateReport(suppliers);

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=suppliers_report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(stream));

	}
}
