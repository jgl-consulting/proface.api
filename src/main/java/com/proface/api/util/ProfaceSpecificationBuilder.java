package com.proface.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.google.common.base.Joiner;
import com.proface.api.specifications.builder.EntityBuilder;
import com.proface.api.specifications.operation.SearchOperation;

@Component
public class ProfaceSpecificationBuilder<E> {

	public Specification<E> getSpecification(String search)
	{
		EntityBuilder<E> builder = new EntityBuilder<>();
		Matcher matcher = Pattern.compile("(\\W?\\w+?)(" + Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET)
				+ ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),").matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
		}
		return builder.build();
	}
	
}
