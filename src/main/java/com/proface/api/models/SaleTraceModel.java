package com.proface.api.models;

import java.time.LocalDate;

import com.proface.api.models.references.SaleStatusRefModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleTraceModel {

	private int id;

	private LocalDate statusDate;

	private SaleStatusRefModel status;
}
