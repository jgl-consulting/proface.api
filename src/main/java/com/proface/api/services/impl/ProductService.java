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
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	@Override
	protected void compareEntity(Product entity, Product repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId()))
				duplicatedId(entity.getNativeId());
		} else
			entity.setNativeId(repositoryEntity.getNativeId());
		if (entity.getName() == null)
			entity.setName(repositoryEntity.getName());
		if (entity.getSalePrice() == 0)
			entity.setSalePrice(repositoryEntity.getSalePrice());
		if (entity.getLine() == null)
			entity.setLine(repositoryEntity.getLine());
	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}

}
