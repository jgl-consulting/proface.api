package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactoModel {
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
}
