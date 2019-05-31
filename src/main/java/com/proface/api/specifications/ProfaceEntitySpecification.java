package com.proface.api.specifications;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.proface.api.specifications.criteria.ProfaceSearchCriteria;

public class ProfaceEntitySpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 7990609545945438878L;

	private ProfaceSearchCriteria criteria;

	public ProfaceEntitySpecification(ProfaceSearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		switch (criteria.getOperation()) {
		case EQUALITY:
			return builder.equal(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case NEGATION:
			return builder.notEqual(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case GREATER_THAN:
			return builder.greaterThan(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case GREATER_EQUAL_THAN:
			return builder.greaterThanOrEqualTo(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case LESS_EQUAL_THAN:
			return builder.lessThanOrEqualTo(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case LIKE:
			return builder.like(concatPath(root, criteria.getKey()), criteria.getValue().toString());
		case STARTS_WITH:
			return builder.like(concatPath(root, criteria.getKey()), criteria.getValue().toString() + "%");
		case ENDS_WITH:
			return builder.like(concatPath(root, criteria.getKey()), "%" + criteria.getValue().toString());
		case CONTAINS:
			return builder.like(concatPath(root, criteria.getKey()), "%" + criteria.getValue().toString() + "%");
		default:
			return null;
		}
	}

	private Path<String> concatPath(Root<T> root, String key) {
		List<String> properties = Arrays.asList(key.split("\\."));
		properties = properties.stream().filter(p -> !p.isEmpty()).map(p -> p.replaceAll("\\W", ""))
				.collect(Collectors.toList());
		if (properties.size() <= 1) {
			return root.get(key);
		} else {
			Path<String> path = root.get(properties.get(0));
			for (int i = 1; i < properties.size(); i++) {
				path = path.get(properties.get(i));
			}
			return path;
		}
	}

}
