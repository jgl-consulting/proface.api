package com.proface.api.models;

import java.time.LocalDate;

import com.proface.api.models.references.UnitStatusRefModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitTraceModel {

	private int id;

	private LocalDate statusDate;

	private UnitStatusRefModel status;

}
