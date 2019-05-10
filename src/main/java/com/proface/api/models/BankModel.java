package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.proface.api.models.references.BaseReferenceModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
    private String name;
	
	private String accountNumberMask;

	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
    private BaseReferenceModel<Integer> country;
	
}
