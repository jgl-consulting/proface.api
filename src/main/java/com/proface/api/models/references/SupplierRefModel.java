package com.proface.api.models.references;

import com.proface.api.models.CountryModel;
import com.proface.api.models.SupplierTypeModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRefModel extends BaseReferenceModel {

	private String name;

	private String nativeId;

	private String address;

	private SupplierTypeModel type;

	private CountryModel country;

}
