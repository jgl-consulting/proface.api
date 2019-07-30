package com.proface.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.proface.api.models.references.ClientTypeRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String name;
	
	@Size(max = 255, message = ProfaceValidationMessage.MAX_SIZE)
	private String address;
	
	@Size(max = 100, message = ProfaceValidationMessage.MAX_SIZE)
	private String district;
	
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Valid
	private ClientTypeRefModel type;
	
}
