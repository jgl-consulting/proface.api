package com.proface.api.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuentaModel {
	
	@NotBlank(message = "El número de cuenta no puede ser vacío.")
	private String nroCuenta;

}
