package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.proface.api.models.references.SupplierRefModel;
import com.proface.api.util.ProfaceValidationMessage;

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
	
	@NotNull
	@Valid
	private SupplierRefModel supplier;
	
}
