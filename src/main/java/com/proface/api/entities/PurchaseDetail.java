package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "purchase_detail")
@Data
public class PurchaseDetail {

	@EmbeddedId
	private PurchaseDetailPK id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id")
	@MapsId("purchase_id")
	private PurchaseOrder purchase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@MapsId("product_id")
	private Product product;
	
	@Column(name = "native_id")
	private String nativeId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "purchase_price")
	private double purchasePrice;
	
	@Column(name = "disscount")
	private double disscount;
	
	@Column(name = "final_price")
	private double finalPrice;
	
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@ManyToOne
	private ReceptionStatus status;
	
}
