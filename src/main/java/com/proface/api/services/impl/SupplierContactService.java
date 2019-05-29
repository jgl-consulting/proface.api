package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SupplierContact;
import com.proface.api.repositories.SupplierContactRepository;
import com.proface.api.services.ISupplierContactService;

@Service
public class SupplierContactService extends BaseService<SupplierContactRepository, SupplierContact, Integer, Integer>
		implements ISupplierContactService {

	@Override
	public void save(SupplierContact entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SupplierContact entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SupplierContact.class.getSimpleName();
	}

}
