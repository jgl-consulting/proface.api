package com.proface.api.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.proface.api.models.references.ProductRefModel;
import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.models.references.ReceptionStatusRefModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;

@Data
public class PurchaseDetailModel {

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private PurchaseOrderRefModel purchase;

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ProductRefModel product;
	
	private String nativeId;

	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;

	private double unitPrice;

	private double purchasePrice;

	private double disscount;

	private double finalPrice;
	
	@NotNull
	private ReceptionStatusRefModel status;

}
