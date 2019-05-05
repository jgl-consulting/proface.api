package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name= "supplier_type")
@Data
public class SupplierType {

	@Id
	@Column(name = "id")
    private int id;
	
	@Column(name = "name")
    private String name;

}
