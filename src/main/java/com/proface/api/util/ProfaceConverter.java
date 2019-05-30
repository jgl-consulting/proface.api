package com.proface.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Util Class to Convert Types
 * 
 * @author josec
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
		iterable.forEach(e -> list.add(e));
		return list;
	}

}
