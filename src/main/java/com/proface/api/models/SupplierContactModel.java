package com.proface.api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierContactModel {

	private String id;

	@NotBlank(message = "El nombre del contacts no puede ser vacío.")
	private String firstName;
	
	@NotBlank(message = "El apellido del contacts no puede ser vacío.")
	private String lastName;
	
	private String phone;
	
	@Email(message = "El correo del contacto debe tener el formato correcto.")
	private String email;
}
