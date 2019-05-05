package com.proface.api.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierAccountModel {

	private int id;

	@NotBlank(message = "El número de accounts no puede ser vacío.")
	private String number;

	private String cci;

	private String description;

	private BankModel bank;

}
