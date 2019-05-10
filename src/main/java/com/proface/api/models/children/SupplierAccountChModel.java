package com.proface.api.models.children;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.proface.api.models.references.BankRefModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierAccountChModel {

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String number;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String cci;

	private String description;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String currency;
	
	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private BankRefModel bank;
	
}
