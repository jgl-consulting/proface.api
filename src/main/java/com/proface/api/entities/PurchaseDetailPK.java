package com.proface.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PurchaseDetailPK implements Serializable {

	private static final long serialVersionUID = 260822197461303045L;

	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "purchase_id")
	private int purchaseId;
	
	public PurchaseDetailPK() {
		
	}
	
	public PurchaseDetailPK(int productId, int purchaseId) {
		this.productId = productId;
		this.purchaseId = purchaseId;
	}
	
}
