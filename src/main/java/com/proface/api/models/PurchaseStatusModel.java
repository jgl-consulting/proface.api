package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseStatusModel {

	private int id;
	
	private String nativeId;
	
	private String description;
	
	private String color;
	
}
