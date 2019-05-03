package com.proface.api.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DireccionModel {
	
	@NotBlank(message = "El nombre de la calle de la dirección no puede ser vacío.")
	private String nombreCalle;
	
	@NotBlank(message = "La ciudad de la dirección no puede ser vacía.")
	private String ciudad;
}
