package com.proface.api.models.references;

import java.time.LocalDate;

import com.proface.api.models.PurchaseStatusModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderRefModel extends BaseReferenceModel {

	private String nativeId;
	
	private LocalDate creationDate;
	
	private LocalDate quotationDate;
	
	private LocalDate receptionDate;
	
	private LocalDate billingDate;
		
	private PurchaseStatusModel status;
	
}
