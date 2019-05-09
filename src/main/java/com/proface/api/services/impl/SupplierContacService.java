package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.SupplierContact;
import com.proface.api.entities.SupplierType;
import com.proface.api.repositories.SupplierContactRepository;
import com.proface.api.services.ISupplierContactService;
import com.proface.api.util.CollectionConverter;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class SupplierContacService extends ProfaceValidationHelper<Integer> implements ISupplierContactService{
	
	@Autowired
	private SupplierContactRepository supplierContactRepository;
	
	@Autowired
	private CollectionConverter<SupplierContact> converter;

	@Override
	public List<SupplierContact> findAll() {
		return converter.iterableToList(supplierContactRepository.findAll());
	}

	@Override
	public Page<SupplierContact> findAll(Pageable pageable) {
		return supplierContactRepository.findAll(pageable);
	}

	@Override
	public SupplierContact findOne(Integer id) {
		Optional<SupplierContact> entity = supplierContactRepository.findById(id);
		if(!entity.isPresent())
			notExisting();
		return entity.get();
	}

	@Override
	public void save(SupplierContact entity) {
		supplierContactRepository.save(entity);
	}

	@Override
	public void edit(Integer id, SupplierContact entity) {
		entity.setId(id);
		notExisting(id);
		supplierContactRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		notExisting(id);
		supplierContactRepository.deleteById(id);	
	}
	
	protected void notExisting(Integer id) {
		if(!supplierContactRepository.existsById(id))
			super.notExisting();
	}
}
