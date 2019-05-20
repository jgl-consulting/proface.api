package com.proface.api.entities;

import lombok.Data;

@Data
public class Currency {

	private String id;
	
	private String name;
	
	public Currency(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
