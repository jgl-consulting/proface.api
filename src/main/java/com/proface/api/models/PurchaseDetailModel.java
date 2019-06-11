package com.proface.api.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.proface.api.models.references.ProductRefModel;
import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.models.references.ReceptionStatusRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;

@Data
public class PurchaseDetailModel {

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private PurchaseOrderRefModel purchase;

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ProductRefModel product;

	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;

	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;

	private double unitPrice;

	private double purchasePrice;

	private double disscount;

	private double finalPrice;
	
	private double localPrice;
	
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ReceptionStatusRefModel status;

}
