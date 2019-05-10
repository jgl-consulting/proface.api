package com.proface.api.models;

import javax.validation.constraints.NotBlank;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceptionStatusModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String description;
	
}