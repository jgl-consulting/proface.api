package com.proface.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CollectionConverter<E> {

	public List<E> iterableToList(Iterable<E> iterable) {
		List<E> list = new ArrayList<>();
		for(E entity: iterable)
			list.add(entity);
		return list;
	}
	
}
