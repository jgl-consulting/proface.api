package com.proface.api.models;

import java.time.LocalDate;

import com.proface.api.entities.PurchaseStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseTraceModel {

	private int id;
	
	private LocalDate statusDate;
	
	private PurchaseStatus status;
	
}
