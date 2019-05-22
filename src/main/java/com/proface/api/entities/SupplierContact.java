package com.proface.api.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "supplier_contact")
@Data
public class SupplierContact {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone", columnDefinition = "char")
	private String phone;

	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

}
