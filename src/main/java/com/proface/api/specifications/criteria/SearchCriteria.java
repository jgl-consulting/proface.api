package com.proface.api.specifications.criteria;

import com.proface.api.specifications.operation.SearchOperation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {

	private String key;
	private SearchOperation operation;
	private Object value;

}
