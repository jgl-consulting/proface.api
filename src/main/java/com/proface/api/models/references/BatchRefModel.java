package com.proface.api.models.references;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchRefModel extends ProfaceRefModel {

	private String nativeId;

	private LocalDate entryDate;

	private LocalDate expirationDate;

	private PurchaseOrderRefModel purchase;

	private BatchTypeRefModel type;
	
}
