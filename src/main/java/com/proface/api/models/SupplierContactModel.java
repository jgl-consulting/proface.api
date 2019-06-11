package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.proface.api.models.references.SupplierRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierContactModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String firstName;

	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String lastName;

	@Size(max = 12, message = ProfaceValidationMessage.MAX_SIZE)
	private String phone;
	
	@Email(message = ProfaceValidationMessage.EMAIL)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String email;
	
	@NotNull
	@Valid
	private SupplierRefModel supplier;
	
}
