package com.proface.api.models.references;

import java.time.LocalDate;

import com.proface.api.models.UserModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderRefModel extends ProfaceRefModel {

	private String nativeId;

	private LocalDate creationDate;

	private double localTotal;

	private SaleStatusRefModel status;

	private ClientRefModel client;

	private UserModel user;

}
