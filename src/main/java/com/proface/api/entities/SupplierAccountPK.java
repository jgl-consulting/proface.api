package com.proface.api.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class SupplierAccountPK implements Serializable {

	private static final long serialVersionUID = -2035800160473596939L;

	@Id
    @Column(name = "supplier_id")
    private int supplierId;

    @Id
    @Column(name = "id")
    private int id;

}
