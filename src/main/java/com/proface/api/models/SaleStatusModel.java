package com.proface.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleStatusModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 2, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String description;

	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String color;

	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String icon;

	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int order;

}
