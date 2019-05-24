package com.proface.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "native_id")
	private String nativeId;

	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	@ManyToOne
	private Currency currency;

	@Column(name = "sale_price")
	private double salePrice;

	@JoinColumn(name = "product_line_id", referencedColumnName = "id")
	@ManyToOne
	private ProductLine line;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<PurchaseDetail> details;

}
