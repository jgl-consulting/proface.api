package com.proface.api.models.references;

import com.proface.api.models.CountryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankRefModel extends ProfaceRefModel {

	private String name;

	private String accountNumberMask;

	private CountryModel country;

}
