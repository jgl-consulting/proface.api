package com.proface.api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author josec
 * This class abstracts basic Methods from a Service
 * Children classes can add custom methods
 * @param <E>	Entity
 * @param <ID>	Primary Key of Entity
 */
public interface IAbstractService<E, ID> {

	/**
	 * Lists all Entities
	 * @return List<entity>
	 */
	List<E> findAll();
	
	/**
	 * Pages Entities
	 * @param pageable
	 * @return Page<entity>
	 */
	Page<E> findAll(Pageable pageable);
	
	/**
	 * Finds an Entity
	 * @param id
	 * @return entity
	 */
	E findOne(ID id);
	
	/**
	 * Saves an Entity
	 * @param entity
	 */
	void save(E entity);
	
	/**
	 * Modifies an Entity
	 * @param id
	 * @param entity
	 */
	void edit(ID id, E entity);
	
	/**
	 * Deletes an Entity
	 * @param id
	 */
	void delete(ID id);
	
}
