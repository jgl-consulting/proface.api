package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SupplierModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String name;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	private String address;
	
	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private SupplierTypeModel type;
	
	private List<@Valid SupplierContactModel> contacts;
	
	private List<@Valid SupplierAccountModel> accounts;

	@Valid
	private CountryModel country;
	
}
