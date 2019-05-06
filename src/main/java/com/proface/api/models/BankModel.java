package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankModel {

	@Positive(message = "El identificador del banco debe ser un número positivo.")
	private int id;
	
    private String name;
	
	private String accountNumberMask;

	@Valid
    private CountryModel country;

}
