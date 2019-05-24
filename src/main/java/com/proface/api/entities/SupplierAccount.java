package com.proface.api.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "supplier_account")
@Data
public class SupplierAccount {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "number")
	private String number;

	@Column(name = "cci")
	private String cci;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	private Currency currency;

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

}
