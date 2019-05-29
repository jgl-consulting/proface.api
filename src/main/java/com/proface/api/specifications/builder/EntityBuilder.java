package com.proface.api.specifications.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.proface.api.specifications.EntitySpecification;
import com.proface.api.specifications.criteria.SearchCriteria;
import com.proface.api.specifications.operation.SearchOperation;

public class EntityBuilder<E> {

	private List<SearchCriteria> params;
	private boolean isAndPredicate;

	public EntityBuilder(boolean isAndPredicate) {
		this.params = new ArrayList<>();
		this.isAndPredicate = isAndPredicate;
	}

	public EntityBuilder<E> with(String key, String operation, Object value, String prefix, String suffix) {
		SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
		if (op != null) {
			if (op == SearchOperation.EQUALITY) {
				boolean startWithAsterisk = prefix.contains("*");
				boolean endWithAsterisk = suffix.contains("*");
				if (startWithAsterisk && endWithAsterisk) {
					op = SearchOperation.CONTAINS;
				} else if (startWithAsterisk) {
					op = SearchOperation.ENDS_WITH;
				} else if (endWithAsterisk) {
					op = SearchOperation.STARTS_WITH;
				}
			}
			params.add(new SearchCriteria(key, op, value));
		}
		return this;
	}

	public Specification<E> build() {
		if (params.size() == 0) {
			return null;
		}
		Specification<E> result = new EntitySpecification<E>(params.get(0));
		for (int i = 1; i < params.size(); i++) {
			result = this.isAndPredicate ? Specification.where(result).and(new EntitySpecification<E>(params.get(i)))
					: Specification.where(result).or(new EntitySpecification<E>(params.get(i)));
		}
		return result;
	}

}
