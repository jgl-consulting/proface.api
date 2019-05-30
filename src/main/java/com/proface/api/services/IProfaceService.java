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
public interface IProfaceService<E, ID> {

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
	 * List all Entities using Searching Query
	 * @return
	 */
	List<E> findAll(String search);
	
	/**
	 * Pages Entities using Searching Query
	 * @param search
	 * @param pageable
	 * @return Page<entity>
	 */
	Page<E> findAll(String search, Pageable pageable);
	
	/**
	 * Finds a searched Entity
	 * @param search
	 * @return
	 */
	E findOne(String search);
	
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
	 * Saves a list of Entities
	 * @param entities
	 */
	void saveAll(List<E> entities);
	
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
