package com.proface.api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAbstractService<E, ID> {

	List<E> findAll();
	
	Page<E> findAll(Pageable pageable);
	
	E findOne(ID id);
	
	void save(E entity);
	
	void edit(ID id, E entity);
	
	void delete(ID id);
	
}
