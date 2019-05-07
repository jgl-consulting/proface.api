package com.proface.api.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseOrderModel {

	private String nativeId;
	
	private LocalDate creationDate;
	
	private LocalDate quotationDate;
	
	private LocalDate receptionDate;
	
	private SupplierModel supplier;
	
	private PurchaseStatusModel status;
	
	private List<PurchaseDetailModel> details;
	
	
}
