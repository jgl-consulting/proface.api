package com.proface.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoProveedorModel {
	
	@NotNull(message = "El identificador del tipo de proveedor no puede ser vacío.")
	private Integer idTipoProveedor;
	
	@NotBlank(message = "La descripción del tipo de proveedor no puede ser vacía.")
	private String descripcion;
	
	@NotBlank(message = "El tipo de moneda de este tipo de proveedor no puede ser vacío.")
	private String tipoMoneda;

}
