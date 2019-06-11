package com.proface.api.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.proface.api.models.references.BatchTypeRefModel;
import com.proface.api.models.references.PurchaseOrderRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BatchModel {

	private int id;

	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;

	@PastOrPresent(message = ProfaceValidationMessage.PAST_PRESENT)
	private LocalDate entryDate;

	@FutureOrPresent(message = ProfaceValidationMessage.FUTURE_PRESENT)
	private LocalDate expirationDate;

	@Valid
	private PurchaseOrderRefModel purchase;

	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Valid
	private BatchTypeRefModel type;

	private List<UnitModel> units;
	
}
