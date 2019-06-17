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

import com.proface.api.entities.Unit;
import com.proface.api.mappers.UnitMapper;
import com.proface.api.models.UnitModel;
import com.proface.api.reports.UnitReport;
import com.proface.api.services.IUnitService;

@RestController
@RequestMapping("api/units")
public class UnitController extends ProfaceController<Integer, Unit, UnitModel, UnitMapper, IUnitService> {

	@Autowired
	private UnitReport reportGenerator;	
	
	@GetMapping(value = "reports", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> unitReport() {

		List<Unit> units = super.getService().findAll();

		ByteArrayInputStream stream = reportGenerator.generateProductReport(units);

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=unit_report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(stream));

	}
}
