package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.SupplierType;
import com.proface.api.repositories.SupplierTypeRepository;
import com.proface.api.services.ISupplierTypeService;
import com.proface.api.util.CollectionConverter;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class SupplierTypeService extends ProfaceValidationHelper<Integer> implements ISupplierTypeService {

	@Autowired
	private SupplierTypeRepository supplierTypeRepository;
	
	@Autowired
	private CollectionConverter<SupplierType> converter;	
	
	@Override
	public List<SupplierType> findAll() {
		return converter.iterableToList(supplierTypeRepository.findAll());
	}

	@Override
	public Page<SupplierType> findAll(Pageable pageable) {
		return supplierTypeRepository.findAll(pageable);
	}

	@Override
	public SupplierType findOne(Integer id) {
		Optional<SupplierType> entity = supplierTypeRepository.findById(id);
		if(!entity.isPresent())
			notExisting();
		return entity.get();
	}

	@Override
	public void save(SupplierType entity) {
		supplierTypeRepository.save(entity);
	}

	@Override
	public void edit(Integer id, SupplierType entity) {
		entity.setId(id);
		notExisting(id);
		supplierTypeRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		notExisting(id);
		supplierTypeRepository.deleteById(id);		
	}
	
	protected void notExisting(Integer id) {
		if(!supplierTypeRepository.existsById(id))
			super.notExisting();
	}
	
	@Override
	protected String getEntityName() {
		return SupplierType.class.getSimpleName();
	}

}
