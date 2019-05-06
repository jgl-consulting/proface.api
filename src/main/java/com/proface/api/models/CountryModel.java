package com.proface.api.models;

import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryModel {

	@Positive(message = "El identificador del país debe ser un número positivo.")
	private int id;
	
    private String name;

    private String iso;
}
