package com.proface.api.models.references;

import java.time.LocalDate;
import java.util.List;

import com.proface.api.models.CurrencyModel;
import com.proface.api.models.PurchaseStatusModel;
import com.proface.api.models.PurchaseTraceModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderRefModel extends ProfaceRefModel {

	private String nativeId;
		
	private LocalDate creationDate;
	
	private PurchaseStatusModel status;
	
	private SupplierRefModel supplier;
	
	private CurrencyModel currency;
	
	private double total;
	
	private List<PurchaseTraceModel> traces;
	
}
