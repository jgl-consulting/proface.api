package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseDetailModel {

	@NotEmpty(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;

	@Valid
	private ProductModel product;
	
	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;
	
	private double unitPrice;
	
	private double purchasePrice;
	
	private double disscount;
	
	private double finalPrice;
	
}
