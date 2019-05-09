package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.ProductLine;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;
import com.proface.api.repositories.ProductLineRepository;
import com.proface.api.services.IProductLineService;
import com.proface.api.util.CollectionConverter;
import com.proface.api.validations.ProfaceValidationHelper;
import com.proface.api.validations.ProfaceValidationMessage;

@Service
public class ProductLineService extends ProfaceValidationHelper<Integer> implements IProductLineService {

	@Autowired
	private ProductLineRepository productLineRepository;
	
	@Autowired
	private CollectionConverter<ProductLine> converter;

	@Override
	public List<ProductLine> findAll() {
		return converter.iterableToList(productLineRepository.findAll());
	}

	@Override
	public Page<ProductLine> findAll(Pageable pageable) {
		return productLineRepository.findAll(pageable);
	}

	@Override
	public ProductLine findOne(Integer id) {
		Optional<ProductLine> entity = productLineRepository.findById(id);
		if(!entity.isPresent())
			notExisting();
		return entity.get();
	}

	@Override
	public void save(ProductLine entity) {
		productLineRepository.save(entity);
	}

	@Override
	public void edit(Integer id, ProductLine entity) {
		entity.setId(id);
		notExisting(id);
		productLineRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		notExisting(id);
		productLineRepository.deleteById(id);		
	}
	
	protected void notExisting(int id) {
		if(!productLineRepository.existsById(id))
			throw new ProfaceNotExistingException(String.format(ProfaceValidationMessage.NOT_EXISTING, getEntityName()));
	}
	
	@Override
	protected String getEntityName() {
		return ProductLine.class.getSimpleName();
	}

}
