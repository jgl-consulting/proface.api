package com.proface.api.models.children;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.proface.api.models.references.BaseReferenceModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseDetailChModel {

	@Valid
	@NotNull
	private BaseReferenceModel<Integer> product;
	
	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;
	
}
