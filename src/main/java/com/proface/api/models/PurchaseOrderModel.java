package com.proface.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.proface.api.validations.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseOrderModel {

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private String nativeId;
	
	private LocalDate creationDate;
	
	private LocalDate quotationDate;
	
	private LocalDate receptionDate;
	
	@Valid
	private SupplierModel supplier;
	
	@Valid
	private PurchaseStatusModel status;
	
	@NotEmpty(message = ProfaceValidationMessage.NOT_EMPTY)
	private List<@Valid PurchaseDetailModel> details;
	
}
