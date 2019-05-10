package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.proface.api.models.references.ProductLineRefModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String name;
	
	private String description;
	
	@PositiveOrZero(message = ProfaceValidationMessage.POSITIVE)
	private double salePrice;
	
	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ProductLineRefModel line;
	
}
