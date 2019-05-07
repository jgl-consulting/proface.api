package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseDetailModel {

	private String nativeId;

	private int quantity;
	
	private double unitPrice;
	
	private double purchasePrice;
	
	private double disscount;
	
	private double finalPrice;
	
}
