package com.proface.api.models;

import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductLineModel {
	
	@Positive(message = "El identificador de la línea de producto debe ser positivo.")
	private int id;
	
	private String name;

}
