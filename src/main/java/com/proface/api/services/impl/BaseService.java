package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Joiner;
import com.proface.api.services.IAbstractService;
import com.proface.api.specifications.builder.EntityBuilder;
import com.proface.api.specifications.operation.SearchOperation;
import com.proface.api.util.ProfaceConverter;
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
public class BaseService<R extends PagingAndSortingRepository<E, ID> & JpaSpecificationExecutor<E>, E, ID, NID>
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
	private ProfaceConverter<E> converter;

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
	 * Pages Entities by Seach Query from Repository
	 */
	@Override
	public Page<E> search(String search, Pageable pageable) {
		char firstChar = search.charAt(0);
		if (firstChar == '+' || firstChar == '-') {
			search = search.substring(1);
		}
		EntityBuilder<E> builder = new EntityBuilder<>(firstChar == '+');
		String operationSet = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
		Pattern pattern = Pattern.compile("(\\w+?)(" + operationSet + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
		}
		Specification<E> specification = builder.build();
		Page<E> page = repository.findAll(specification, pageable);
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
		compareEntity(entity, repositoryEntity.get());
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
	 * Compares incoming entity with persisted entity
	 */
	protected void compareEntity(E entity, E repositoryEntity) {
		
	}

	/**
	 * Prepares the Entity before persisting
	 * 
	 * @param entity
	 */
	protected void prepareEntity(E entity) {

	}

}
