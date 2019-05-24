package com.proface.api.models;

import java.time.LocalDate;

import com.proface.api.models.references.PurchaseStatusRefModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseTraceModel {

	private int id;
	
	private LocalDate statusDate;
	
	private PurchaseStatusRefModel status;
	
}
