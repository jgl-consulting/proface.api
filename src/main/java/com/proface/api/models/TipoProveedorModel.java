package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoProveedorModel {
	private Integer idTipoProveedor;
	private String descripcion;
	private String tipoMoneda;

}
