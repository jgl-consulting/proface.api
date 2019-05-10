package com.proface.api.models.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseStatusRefModel extends BaseReferenceModel {

	private String nativeId;
	
	private String description;
	
	private String color;
	
}
