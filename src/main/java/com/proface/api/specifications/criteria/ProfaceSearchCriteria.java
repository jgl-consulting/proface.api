package com.proface.api.specifications.criteria;

import com.proface.api.specifications.operation.ProfaceSearchOperation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfaceSearchCriteria {

	private String key;
	private ProfaceSearchOperation operation;
	private Object value;

}
