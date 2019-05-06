package com.proface.api.entities;

import lombok.Data;

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

@Entity
@Table(name = "supplier")
@Data
public class Supplier {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "native_id")
	private String nativeId;

	@JoinColumn(name = "type_id", referencedColumnName = "id")
	@ManyToOne
	private SupplierType type;

	@JoinColumn(name = "country_id", referencedColumnName = "id")
	@ManyToOne
	private Country country;

	@OneToMany(
			mappedBy = "supplier",
			fetch = FetchType.LAZY
	)
	private List<SupplierContact> contacts;

	@OneToMany(
			mappedBy = "supplier",
			fetch = FetchType.LAZY
	)
	private List<SupplierAccount> accounts;

}
