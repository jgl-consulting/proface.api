package com.proface.api.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientTypeModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String name;
}
