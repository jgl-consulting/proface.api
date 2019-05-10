package com.proface.api.models.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRefModel extends BaseReferenceModel {

	private String name;

    private String iso;
	
}
