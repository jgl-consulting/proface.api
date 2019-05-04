package com.proface.api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactoModel {
	
	@NotBlank(message = "El nombre del contacto no puede ser vacío.")
	private String nombre;
	
	@NotBlank(message = "El apellido del contacto no puede ser vacío.")
	private String apellido;
	
	private String telefono;
	
	@Email(message = "El correo del contacto debe tener el formato correcto.")
	private String correo;
}
