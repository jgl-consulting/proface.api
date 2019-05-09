package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.services.IAbstractService;
import com.proface.api.util.CollectionConverter;
import com.proface.api.validations.ProfaceValidationHelper;

public class BaseService<R extends PagingAndSortingRepository<E, ID>, E, ID, NID> extends ProfaceValidationHelper<NID> implements IAbstractService<E, ID> {
	
	@Autowired
	private R repository;
	
	@Autowired
	private CollectionConverter<E> converter;	
	
	@Override
	public List<E> findAll() {
		return converter.iterableToList(repository.findAll());
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public E findOne(ID id) {
		Optional<E> entity = repository.findById(id);
		if(!entity.isPresent())
			super.notExisting();
		return entity.get();
	}

	@Override
	@Transactional
	public void save(E entity) {
		repository.save(entity);
	}

	@Override
	@Transactional
	public void edit(ID id, E entity) {
		E repositoryEntity = findOne(id);
		compareEntity(entity, repositoryEntity);
		repository.save(entity);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		notExisting(id);
		repository.deleteById(id);
	}
	
	protected R getRepository() {
		return this.repository;
	}
	
	protected void compareEntity(E entity, E repositoryEntity) {
		
	}
	
	protected void notExisting(ID id) {
		if (!repository.existsById(id))
			super.notExisting();
	}

}
