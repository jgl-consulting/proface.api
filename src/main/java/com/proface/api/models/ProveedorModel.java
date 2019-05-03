package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProveedorModel {

	@NotBlank(message = "El identificador del proveedor no puede ser vacío.")
	private String idProveedor;
	
	@NotBlank(message = "El nombre no puede ser vacío.")
	private String nombre;
	
	@NotNull(message = "El tipo de proveedor no puede ser nulo.")
	private TipoProveedorModel tipoProveedor;

	@Valid
	private ContactoModel contacto;

	@Valid
	private CuentaModel cuenta;

	@Valid
	private DireccionModel direccion;
	
}
