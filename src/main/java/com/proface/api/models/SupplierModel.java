package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.proface.api.models.children.SupplierAccountChModel;
import com.proface.api.models.children.SupplierContactChModel;
import com.proface.api.models.references.CountryRefModel;
import com.proface.api.models.references.SupplierTypeRefModel;
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
	private SupplierTypeRefModel type;
	
	private List<@Valid SupplierContactChModel> contacts;
	
	private List<@Valid SupplierAccountChModel> accounts;

	@Valid
	private CountryRefModel country;
	
}
