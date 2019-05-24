package com.proface.api.models.references;

import java.util.List;

import com.proface.api.models.PurchaseStatusModel;
import com.proface.api.models.PurchaseTraceModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderRefModel extends BaseReferenceModel {

	private String nativeId;
		
	private PurchaseStatusModel status;
	
	private SupplierRefModel supplier;
	
	private List<PurchaseTraceModel> traces;
	
}
