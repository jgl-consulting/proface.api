package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseCostModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 300, message = ProfaceValidationMessage.MAX_SIZE)
	private String description;
	
	@PositiveOrZero(message = ProfaceValidationMessage.POSITIVE)
	private double totalCost;
	
	private double localCost;
	
	private CurrencyModel currency;
	
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Valid
	private PurchaseOrderRefModel purchase;
	
}
