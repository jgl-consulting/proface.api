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
@Table(name = "sale_order")
@Data
public class SaleOrder {

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
	private SaleStatus status;
	
	@Column(name = "local_total")
	private double localTotal;
	
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	@ManyToOne
	private Client client;
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
	private List<SaleTrace> traces;
	
	@OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
	private List<SaleDetail> details;
}
