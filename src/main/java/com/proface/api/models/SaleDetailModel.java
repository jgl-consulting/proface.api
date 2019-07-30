package com.proface.api.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.proface.api.models.references.ProductRefModel;
import com.proface.api.models.references.SaleOrderRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;

@Data
public class SaleDetailModel {

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private SaleOrderRefModel sale;

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ProductRefModel product;

	@Positive(message = ProfaceValidationMessage.POSITIVE)
	private int quantity;

	private double unitPrice;

	private double salePrice;

	private double disscount;

	private double localPrice;

}
