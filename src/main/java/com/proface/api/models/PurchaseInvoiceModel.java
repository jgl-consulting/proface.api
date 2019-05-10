package com.proface.api.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseInvoiceModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	private String description;
	
	@PastOrPresent(message = ProfaceValidationMessage.PAST_PRESENT)
	private LocalDate emissionDate;
	
	@PositiveOrZero(message = ProfaceValidationMessage.POSITIVE)
	private double totalPrice;
	
}
