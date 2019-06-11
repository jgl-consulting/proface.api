package com.proface.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "unit_trace")
@Data
public class UnitTrace {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "status_date")
	private LocalDate statusDate;
	
	@JoinColumn(name = "unit_id")
	@ManyToOne
	private Unit unit;
	
	@JoinColumn(name = "status_id")
	@ManyToOne
	private UnitStatus status;
	
}
