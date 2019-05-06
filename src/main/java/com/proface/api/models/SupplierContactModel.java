package com.proface.api.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierContactModel {

	private int id;

	@NotBlank(message = "El nombre del contacto no debe ser vacío.")
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	@Email(message = "El correo del contacto debe tener el formato correcto.")
	private String email;
	
	private SupplierModel supplier;
	
}
