package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.services.IProfaceService;
import com.proface.api.util.ProfaceConverter;
import com.proface.api.util.ProfaceSpecificationBuilder;
import com.proface.api.util.ProfaceValidationHelper;

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
public class ProfaceService<R extends PagingAndSortingRepository<E, ID> & JpaSpecificationExecutor<E>, E, ID, NID>
		extends ProfaceValidationHelper<E, NID> implements IProfaceService<E, ID> {

	/**
	 * Injected Repository
	 */
	@Autowired
	private R repository;

	/**
	 * Injected Converter
	 */
	@Autowired
	private ProfaceConverter<E> converter;
	
	@Autowired
	private ProfaceSpecificationBuilder<E> builder;

	/**
	 * Lists all Entities from Repository
	 */
	@Override
	public List<E> findAll() {
		List<E> list = converter.iterableToList(repository.findAll());
		list.forEach(e -> filterEntity(e));
		return list;
	}
	
	@Override
	public List<E> findAll(String search) {
		List<E> list = converter.iterableToList(repository.findAll(builder.getSpecification(search)));
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
	 * Pages Entities by Seach Query from Repository
	 */
	@Override
	public Page<E> findAll(String search, Pageable pageable) {
		Page<E> page = repository.findAll(builder.getSpecification(search), pageable);
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
	 * Finds a searched Entity from Repository
	 */
	@Override
	public E findOne(String search) {
		Optional<E> entity = repository.findOne(builder.getSpecification(search));
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
	
	@Override
	@Transactional
	public void saveAll(List<E> entities) {
		entities.forEach(e -> prepareEntity(e));
		repository.saveAll(entities);
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
		prepareEntity(entity);
		compareEntity(entity, repositoryEntity.get());
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

}
