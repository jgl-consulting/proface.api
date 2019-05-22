package com.proface.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "purchase_invoice")
@Data
public class PurchaseInvoice {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "native_id")
	private String nativeId;

	@Column(name = "description")
	private String description;

	@Column(name = "emission_date")
	private LocalDate emissionDate;

	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id")
	private PurchaseOrder purchase;
}
