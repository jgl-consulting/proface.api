package com.proface.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SaleDetailPK implements Serializable {
	
	private static final long serialVersionUID = 8288988170327121973L;
	
	@Column(name = "sale_id")
	private int saleId;

	@Column(name = "product_id")
	private int productId;
	
	public SaleDetailPK() {
		
	}

	public SaleDetailPK(int saleId, int productId) {
		super();
		this.saleId = saleId;
		this.productId = productId;
	}
	
}
