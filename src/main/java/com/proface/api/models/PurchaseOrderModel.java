package com.proface.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import com.proface.api.models.children.PurchaseDetailChModel;
import com.proface.api.models.references.PurchaseStatusRefModel;
import com.proface.api.models.references.SupplierRefModel;
import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseOrderModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	@PastOrPresent(message = ProfaceValidationMessage.PAST_PRESENT)
	private LocalDate creationDate;
	
	private LocalDate quotationDate;
	
	private LocalDate receptionDate;
	
	private LocalDate billingDate;
	
	private LocalDate cancellationDate;
	
	@Valid
	private SupplierRefModel supplier;
	
	@Valid
	private PurchaseStatusRefModel status;
	
	@NotEmpty(message = ProfaceValidationMessage.NOT_EMPTY)
	private List<@Valid PurchaseDetailChModel> details;
	
}
