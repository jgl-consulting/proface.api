package com.proface.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierTypeModel {
	
	@NotNull(message = "El identificador del tipo de proveedor no puede ser vacío.")
	private int id;
	
	@NotBlank(message = "La descripción del tipo de proveedor no puede ser vacía.")
	private String name;

}
