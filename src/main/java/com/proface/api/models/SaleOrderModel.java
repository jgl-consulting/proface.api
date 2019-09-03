package com.proface.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.proface.api.models.children.SaleDetailChModel;
import com.proface.api.models.references.ClientRefModel;
import com.proface.api.models.references.SaleStatusRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleOrderModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;

	@PastOrPresent(message = ProfaceValidationMessage.PAST_PRESENT)
	private LocalDate creationDate;

	private double localTotal;

	@Valid
	private SaleStatusRefModel status;

	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ClientRefModel client;

	@Valid
	private UserModel user;

	private List<@Valid SaleDetailChModel> details;

	private List<SaleInvoiceModel> invoices;

	private List<SaleTraceModel> traces;

}
