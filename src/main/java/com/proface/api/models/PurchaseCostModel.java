package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseCostModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String description;
	
	@PositiveOrZero(message = ProfaceValidationMessage.POSITIVE)
	private double totalCost;
	
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Valid
	private PurchaseOrderRefModel purchase;
	
}
