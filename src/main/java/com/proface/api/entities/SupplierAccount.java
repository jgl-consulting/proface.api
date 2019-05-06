package com.proface.api.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "supplier_account")
@IdClass(SupplierAccountPK.class)
@Data
public class SupplierAccount {

	@Id
	@Column(name = "supplier_id")
	private int supplierId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="number")
	private String number;

	@Column(name="cci", columnDefinition = "char")
	private String cci;

	@Column(name="description")
	private String description;

	@Column(name="currency", columnDefinition = "char")
	private String currency;

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", insertable = false, updatable = false)
	private Supplier supplier;

}
