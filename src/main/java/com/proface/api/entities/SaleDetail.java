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
@Table(name = "sale_detail")
@Data
public class SaleDetail {

	@EmbeddedId
	private SaleDetailPK id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sale_id")
	@MapsId("sale_id")
	private SaleOrder sale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@MapsId("product_id")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "sale_price")
	private double salePrice;
	
	@Column(name = "disscount")
	private double disscount;

	@Column(name = "local_price")
	private double localPrice;
	
}
