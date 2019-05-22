package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.services.IAbstractService;
import com.proface.api.util.Converter;
import com.proface.api.validations.ProfaceValidationHelper;

/**
 * 
 * @author josec This class abstracts basic implementation of Service Children
 *         classes can implement their Service Inteface to use custom methods
 * @param <R>
 *            Repository
 * @param <E>
 *            Entity
 * @param <ID>
 *            Primary Key of Entity
 * @param <NID>
 *            Optional: Native Key of Entity
 */
public class BaseService<R extends PagingAndSortingRepository<E, ID>, E, ID, NID>
		extends ProfaceValidationHelper<E, NID> implements IAbstractService<E, ID> {

	/**
	 * Injected Repository
	 */
	@Autowired
	private R repository;

	/**
	 * Injected Converter
	 */
	@Autowired
	private Converter<E> converter;

	/**
	 * Lists all Entities from Repository
	 */
	@Override
	public List<E> findAll() {
		List<E> list = converter.iterableToList(repository.findAll());
		list.forEach(e -> filterEntity(e));
		return list;
	}

	/**
	 * Pages Entites from Repository
	 */
	@Override
	public Page<E> findAll(Pageable pageable) {
		Page<E> page = repository.findAll(pageable);
		page.forEach(e -> filterEntity(e));
		return page;
	}

	/**
	 * Finds an Entity from Repository
	 */
	@Override
	public E findOne(ID id) {
		Optional<E> entity = repository.findById(id);
		if (!entity.isPresent()) {
			super.notExisting();
		}
		filterEntity(entity.get());
		return entity.get();
	}

	/**
	 * Saves an Entity into Repository
	 */
	@Override
	@Transactional
	public void save(E entity) {
		prepareEntity(entity);
		repository.save(entity);
	}

	/**
	 * Saves a modified Entity into Repository
	 */
	@Override
	@Transactional
	public void edit(ID id, E entity) {
		Optional<E> repositoryEntity = repository.findById(id);
		if (!repositoryEntity.isPresent()) {
			super.notExisting();
		}
		super.compareEntity(entity, repositoryEntity.get());
		prepareEntity(entity);
		repository.save(entity);
	}

	/**
	 * Deletes an Entity from Reprository
	 */
	@Override
	@Transactional
	public void delete(ID id) {
		notExisting(id);
		repository.deleteById(id);
	}

	/**
	 * Returns Repository Usage: If Childrens of this class needs it.
	 * 
	 * @return
	 */
	protected R getRepository() {
		return this.repository;
	}

	/**
	 * Validates if Entity exists in Repository by its ID
	 * 
	 * @param id
	 */
	protected void notExisting(ID id) {
		if (!repository.existsById(id)) {
			super.notExisting();
		}
	}

	/**
	 * Filters the Entity before returning Usage: If Childrens of this calss needs
	 * it
	 */
	protected void filterEntity(E entity) {

	}

	/**
	 * Prepares the Entity before persisting
	 * 
	 * @param entity
	 */
	protected void prepareEntity(E entity) {

	}

}
