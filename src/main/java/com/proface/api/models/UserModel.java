package com.proface.api.models;

import javax.validation.constraints.Email;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserModel {

    private String firstName;

    private String lastName;

    @Email(message = ProfaceValidationMessage.EMAIL)
    private String email;

}
