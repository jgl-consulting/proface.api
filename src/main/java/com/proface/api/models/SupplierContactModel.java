package com.proface.api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierContactModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	@Email(message = ProfaceValidationMessage.EMAIL)
	private String email;
	
}
