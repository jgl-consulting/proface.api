package com.proface.api.entities;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "supplier")
@Data
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name="address")
	private String address;

	@Column(name="native_id")
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
