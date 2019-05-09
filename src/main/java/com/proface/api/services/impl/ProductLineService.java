package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.ProductLine;
import com.proface.api.repositories.ProductLineRepository;
import com.proface.api.services.IProductLineService;

@Service
public class ProductLineService extends BaseService<ProductLineRepository, ProductLine, Integer, Integer>
		implements IProductLineService {

	@Override
	public void save(ProductLine entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, ProductLine entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	protected String getEntityName() {
		return ProductLine.class.getSimpleName();
	}

}