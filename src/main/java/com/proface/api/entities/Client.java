package com.proface.api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private LocalDate submitDate;
	
}
