package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SupplierModel {

	private int id;
	
	@NotBlank(message = "El nombre del proveedor no debe ser vacío.")
	private String name;
	
	@NotBlank(message = "El identificador del proveedor no debe ser vacío.")
	private String nativeId;
	
	private String address;
	
	@Valid
	@NotNull(message = "El tipo de proveedor no debe ser vacío.")
	private SupplierTypeModel type;
	
	@Valid
	private List<SupplierContactModel> contacts;
	
	@Valid
	private List<SupplierAccountModel> accounts;

	@Valid
	private CountryModel country;
}
