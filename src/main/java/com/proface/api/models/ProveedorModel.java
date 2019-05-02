package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProveedorModel {

	private String idProveedor;
	private String nombre;
	private TipoProveedorModel tipoProveedor;
	private ContactoModel contacto;
	private CuentaModel cuenta;
	private DireccionModel direccion;
	
}
