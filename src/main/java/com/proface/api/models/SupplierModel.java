package com.proface.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SupplierModel {

	private int id;
	
	@NotBlank(message = "El nombre no puede ser vacío.")
	private String name;

	@NotBlank(message = "El codigo local no puede ser vacio")
	private String nativeId;

	@NotBlank(message = "La dirección no puede ser vacia")
	private String address;

	@NotNull(message = "El tipo de proveedor no puede ser nulo.")
	private SupplierTypeModel type;
	
	private List<SupplierContactModel> contacts;
	
	private List<SupplierAccountModel> accounts;

	private CountryModel country;
}
