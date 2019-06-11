package com.proface.api.entities;

import java.time.LocalDate;
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
@Table(name = "purchase_order")
@Data
public class PurchaseOrder {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "native_id")
	private String nativeId;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@ManyToOne
	private PurchaseStatus status;

	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
	@ManyToOne
	private Supplier supplier;

	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	@ManyToOne
	private Currency currency;

	@Column(name = "total")
	private double total;

	@Column(name = "local_total")
	private double localTotal;

	@Column(name = "localCost")
	private double localCost;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<PurchaseCost> costs;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<PurchaseDetail> details;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<PurchaseInvoice> invoices;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<PurchaseTrace> traces;

	@OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
	private List<Batch> batches;
}
