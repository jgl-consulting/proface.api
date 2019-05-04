package com.proface.api.models;

import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioModel {

    private String firstName;

    private String lastName;

    @Email(message = "El correo del usuario debe tener el formato correcto.")
    private String email;

}
