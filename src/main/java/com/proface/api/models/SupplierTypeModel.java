package com.proface.api.models;

import javax.validation.constraints.Positive;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierTypeModel {
	
	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int id;
	
	private String name;

}
