package com.proface.api.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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

	@Column(name = "quotation_date")
	private LocalDate quotationDate;
	
	@Column(name = "reception_date")
	private LocalDate receptionDate;
	
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@ManyToOne
	private PurchaseStatus status;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
	@ManyToOne
	private Supplier supplier;
	
	@OneToMany(
			mappedBy = "purchase",
			fetch = FetchType.LAZY
	)
	private List<PurchaseCost> costs;
	
	@OneToMany(
			mappedBy = "purchase",
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<PurchaseDetail> details;
	
	@OneToMany(
			mappedBy = "purchase",
			fetch = FetchType.LAZY
	)
	private List<PurchaseInvoice> invoices;
	
	public void setDetails(List<PurchaseDetail> details) {
		if(details != null) {
			this.details = details;
			details.forEach(detail -> detail.setPurchase(this));
		}
	}
	
}
