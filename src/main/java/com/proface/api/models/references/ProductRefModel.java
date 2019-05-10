package com.proface.api.models.references;

import com.proface.api.models.ProductLineModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRefModel extends BaseReferenceModel {

	private String nativeId;
	
	private String name;
	
	private String description;
	
	private double salePrice;
	
	private ProductLineModel line;
	
}
