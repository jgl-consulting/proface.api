package com.proface.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.Product;
import com.proface.api.repositories.ProductRepository;
import com.proface.api.services.IProductService;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class ProductService extends ProfaceValidationHelper<String> implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product findOne(Integer id) {
		Optional<Product> entity = productRepository.findById(id);
		notExisting(id);
		return entity.get();
	}

	@Override
	public void save(Product entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		productRepository.save(entity);
	}

	@Override
	public void edit(Integer id, Product entity) {
		entity.setId(id);
		notExisting(id);
		duplicatedId(entity.getNativeId());
		productRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		notExisting(id);
		productRepository.deleteById(id);
	}

	protected void duplicatedId(String nativeId) {
		if (productRepository.existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	protected void notExisting(int id) {
		if (!productRepository.existsById(id))
			super.notExisting();
	}
	
	protected String getEntityName() {
		return "El Producto";
	}

}
