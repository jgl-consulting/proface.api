package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DireccionModel {
	private String idDireccion;
	private String nombreCalle;
	private String ciudad;
}
