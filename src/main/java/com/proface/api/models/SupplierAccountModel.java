package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierAccountModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String number;

	private String cci;

	private String description;
	
	private String currency;
	
	@Valid
	private BankModel bank;

}
