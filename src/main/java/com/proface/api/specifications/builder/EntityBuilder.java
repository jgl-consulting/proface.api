package com.proface.api.specifications.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.proface.api.specifications.EntitySpecification;
import com.proface.api.specifications.criteria.SearchCriteria;
import com.proface.api.specifications.operation.SearchOperation;

public class EntityBuilder<E> {

	private List<SearchCriteria> params;

	public EntityBuilder() {
		this.params = new ArrayList<>();
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
		removeSpecialCharacters(params.get(0));
		Specification<E> result = new EntitySpecification<E>(params.get(0));
		for (int i = 1; i < params.size(); i++) {
			result = keyContainsAndJoiner(params.get(i))
					? Specification.where(result).and(new EntitySpecification<E>(params.get(i)))
					: Specification.where(result).or(new EntitySpecification<E>(params.get(i)));
		}
		return result;
	}

	private boolean keyContainsAndJoiner(SearchCriteria criteria) {
		if (criteria.getKey() != null && !criteria.getKey().isEmpty()) {
			char firstChar = criteria.getKey().charAt(0);
			removeSpecialCharacters(criteria);
			return firstChar == '¬';
		}
		return false;
	}

	private void removeSpecialCharacters(SearchCriteria criteria) {
		criteria.setKey(criteria.getKey().replaceAll("\\W", ""));
	}

}
