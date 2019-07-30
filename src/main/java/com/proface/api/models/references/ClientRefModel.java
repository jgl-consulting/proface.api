package com.proface.api.models.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRefModel extends ProfaceRefModel {

	private String nativeId;

	private String name;

	private String address;

	private String district;

	private ClientTypeRefModel type;
}
