package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductModel {

	private int id;
	
	@NotBlank(message = "El identificador del producto no debe ser vacío.")
	private String nativeId;
	
	@NotBlank(message = "El nombre del producto no debe ser vacío.")
	private String name;
	
	private String description;
	
	@Positive(message = "El precio de venta del producto debe ser positivo.")
	private double salePrice;
	
	@Valid
	private ProductLineModel line;
	
}
