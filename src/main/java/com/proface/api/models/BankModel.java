package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.proface.api.models.references.CountryRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 45, message = ProfaceValidationMessage.MAX_SIZE)
    private String name;

	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String accountNumberMask;

	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
    private CountryRefModel country;
	
}
