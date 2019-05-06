package com.proface.api.entities;

import javax.persistence.*;

import lombok.Data;
@Entity
@Table(name= "supplier_type")
@Data
public class SupplierType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "name")
    private String name;

}
