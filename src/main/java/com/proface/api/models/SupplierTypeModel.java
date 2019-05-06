package com.proface.api.models;

import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierTypeModel {
	
	@Positive(message = "El identificador del tipo de proveedor debe ser un número positivo.")
	private int id;
	
	private String name;

}
