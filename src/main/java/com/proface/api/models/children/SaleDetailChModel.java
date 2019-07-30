package com.proface.api.models.children;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.proface.api.models.references.ProductRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleDetailChModel {

	@Valid
	@NotNull
	private ProductRefModel product;
	
	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;
	
	private double unitPrice;
	
	private double purchasePrice;
	
	private double disscount;
	
	private double localPrice;
	
}
