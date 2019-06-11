package com.proface.api.models;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.proface.api.models.references.BatchRefModel;
import com.proface.api.models.references.LocationRefModel;
import com.proface.api.models.references.ProductRefModel;
import com.proface.api.models.references.UnitStatusRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;

	@NotNull
	@Valid
	private ProductRefModel product;

	@Valid
	private LocationRefModel location;

	@NotNull
	@Valid
	private BatchRefModel batch;

	@NotNull
	@Valid
	private UnitStatusRefModel status;
	
	private List<UnitTraceModel> traces;

}
