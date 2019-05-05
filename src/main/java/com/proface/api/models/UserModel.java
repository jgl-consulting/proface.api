package com.proface.api.models;

import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserModel {

    private String firstName;

    private String lastName;

    @Email(message = "El email del usuario debe tener el formato correcto.")
    private String email;

}
