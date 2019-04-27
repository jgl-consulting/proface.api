package com.proface.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.models.ProveedorModel;
import com.proface.api.services.IProveedorService;

@RestController
@RequestMapping("api/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping
	public List<ProveedorModel> findAll() {
		return proveedorService.findAll();
	}
	
}
