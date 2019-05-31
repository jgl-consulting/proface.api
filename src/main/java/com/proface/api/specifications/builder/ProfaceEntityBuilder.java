package com.proface.api.specifications.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.proface.api.specifications.ProfaceEntitySpecification;
import com.proface.api.specifications.criteria.ProfaceSearchCriteria;
import com.proface.api.specifications.operation.ProfaceSearchOperation;

public class ProfaceEntityBuilder<E> {

	private List<ProfaceSearchCriteria> params;

	public ProfaceEntityBuilder() {
		this.params = new ArrayList<>();
	}

	public ProfaceEntityBuilder<E> with(String key, String operation, Object value, String prefix, String suffix) {
		ProfaceSearchOperation op = ProfaceSearchOperation.getSimpleOperation(operation.charAt(0));
		if (op != null) {
			switch (op) {
			case EQUALITY:
				if (prefix.contains("*") && suffix.contains("*")) {
					op = ProfaceSearchOperation.CONTAINS;
				} else if (prefix.contains("*")) {
					op = ProfaceSearchOperation.ENDS_WITH;
				} else if (suffix.contains("*")) {
					op = ProfaceSearchOperation.STARTS_WITH;
				}
				break;
			case GREATER_THAN:
				if (prefix.contains(":")) {
					op = ProfaceSearchOperation.GREATER_EQUAL_THAN;
				}
				break;
			case LESS_THAN:
				if (prefix.contains(":")) {
					op = ProfaceSearchOperation.LESS_EQUAL_THAN;
				}
				break;
			default:
				break;
			}
			params.add(new ProfaceSearchCriteria(key, op, value));
		}
		return this;
	}

	public Specification<E> build() {
		if (params.size() == 0) {
			return null;
		}
		Specification<E> result = new ProfaceEntitySpecification<E>(params.get(0));
		for (int i = 1; i < params.size(); i++) {
			result = keyContainsAndJoiner(params.get(i))
					? Specification.where(result).and(new ProfaceEntitySpecification<E>(params.get(i)))
					: Specification.where(result).or(new ProfaceEntitySpecification<E>(params.get(i)));
		}
		return result;
	}

	private boolean keyContainsAndJoiner(ProfaceSearchCriteria criteria) {
		if (criteria.getKey() != null && !criteria.getKey().isEmpty()) {
			char firstChar = criteria.getKey().charAt(0);
			return firstChar == '¬';
		}
		return false;
	}

}
