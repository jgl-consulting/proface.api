package com.proface.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author josec Util Class to Convert Types
 * @param <E>
 */
@Component
public class ProfaceConverter<E> {

	/**
	 * Converts Iterable to List
	 * 
	 * @param iterable
	 * @return List<entity>
	 */
	public List<E> iterableToList(Iterable<E> iterable) {
		List<E> list = new ArrayList<>();
		for (E entity : iterable) {
			list.add(entity);
		}
		return list;
	}

}
