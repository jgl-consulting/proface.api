package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierAccountModel {

	@NotBlank(message = "El número de cuenta no debe ser vacío.")
	private String number;

	private String cci;

	private String description;
	
	private String currency;
	
	@Valid
	private BankModel bank;

}
