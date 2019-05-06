package com.proface.api.entities;

import lombok.Data;

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

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "supplier")
@Data
@DynamicUpdate
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
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<SupplierContact> contacts;

	@OneToMany(
			mappedBy = "supplier",
			fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST
	)
	private List<SupplierAccount> accounts;

	public void setContacts(List<SupplierContact> contacts) {
		if(contacts != null) {
			this.contacts = contacts;
			contacts.forEach(contact -> contact.setSupplier(this));
		}
	}
	
	public void setAccounts(List<SupplierAccount> accounts) {
		if(accounts != null) {
			this.accounts = accounts;
			accounts.forEach(account -> account.setSupplier(this));
		}
	}
	
}
