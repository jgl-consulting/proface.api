package com.proface.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.User;
import com.proface.api.services.IUserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping
	public ResponseEntity<?> list() {
		
		List<User> list = service.findAll("username:jose.bustamante");

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
