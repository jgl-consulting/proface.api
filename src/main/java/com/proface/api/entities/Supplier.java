package com.proface.api.entities;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

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

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SupplierContact> contacts;

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<SupplierAccount> accounts;

}
