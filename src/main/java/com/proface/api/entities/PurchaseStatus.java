package com.proface.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "purchase_status")
@Data
public class PurchaseStatus {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "native_id")
	private String nativeId;

	@Column(name = "description")
	private String description;

	@Column(name = "color")
	private String color;
	
	@Column(name = "icon")
	private String icon;

	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<PurchaseOrder> orders;

}
