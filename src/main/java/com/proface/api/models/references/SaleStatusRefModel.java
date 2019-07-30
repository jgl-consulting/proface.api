package com.proface.api.models.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleStatusRefModel extends ProfaceRefModel {

	private String nativeId;

	private String description;

	private String color;

	private String icon;

	private int order;
}
