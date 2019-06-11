package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.proface.api.models.children.SupplierAccountChModel;
import com.proface.api.models.children.SupplierContactChModel;
import com.proface.api.models.references.CountryRefModel;
import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.models.references.SupplierTypeRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SupplierModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String name;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;

	@Size(max = 255, message = ProfaceValidationMessage.MAX_SIZE)
	private String address;
	
	@Valid
	private SupplierTypeRefModel type;
	
	private List<@Valid SupplierContactChModel> contacts;
	
	private List<@Valid SupplierAccountChModel> accounts;

	@Valid
	private CountryRefModel country;
	
	private List<PurchaseOrderRefModel> purchases;
	
}
