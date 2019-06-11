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
@Table(name = "batch")
@Data
public class Batch {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "native_id")
	private String nativeId;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id")
	private PurchaseOrder purchase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private BatchType type;

	@OneToMany(mappedBy = "batch", fetch = FetchType.LAZY)
	private List<Unit> units;

}
