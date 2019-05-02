package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoProveedorModel {
	private int idTipoProveedor;
	private String descripcion;
	private String tipoMoneda;

}
