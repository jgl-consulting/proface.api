package com.proface.api.models.references;

import com.proface.api.models.PurchaseStatusModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderRefModel extends BaseReferenceModel {

	private String nativeId;
		
	private PurchaseStatusModel status;
	
	private SupplierRefModel supplier;
	
}
