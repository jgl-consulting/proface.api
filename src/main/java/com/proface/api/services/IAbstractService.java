package com.proface.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAbstractService<E, ID> {

	Page<E> findAll(Pageable pageable);
	
	E findOne(ID id);
	
	void save(E entity);
	
	void edit(ID id, E entity);
	
	void delete(ID id);
	
}
