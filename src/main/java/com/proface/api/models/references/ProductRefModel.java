package com.proface.api.models.references;

import com.proface.api.models.CurrencyModel;
import com.proface.api.models.ProductLineModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRefModel extends ProfaceRefModel {

	private String nativeId;
	
	private String name;
	
	private String description;
	
	private CurrencyModel currency;
	
	private double salePrice;
	
	private double localPrice;
	
	private ProductLineModel line;
	
}
