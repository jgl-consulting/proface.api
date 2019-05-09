package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Product;
import com.proface.api.entities.Supplier;
import com.proface.api.repositories.ProductRepository;
import com.proface.api.services.IProductService;

@Service
public class ProductService extends BaseService<ProductRepository, Product, Integer, String>
		implements IProductService {

	@Override
	public void save(Product entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Product entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	@Override
	protected void compareEntity(Product entity, Product repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else
			entity.setNativeId(repositoryEntity.getNativeId());
	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}

}