package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.ClientType;
import com.proface.api.repositories.ClientTypeRepository;
import com.proface.api.services.IClientTypeService;

@Service
public class ClientTypeService extends ProfaceService<ClientTypeRepository, ClientType, Integer, String>
		implements IClientTypeService {

	@Override
	public void save(ClientType entity) {
		entity.setId(0);
		super.save(entity);
	}
	
	@Override
	public void edit(Integer id, ClientType entity) {
		entity.setId(id);
		super.edit(id, entity);
	}
	
	@Override
	protected String getEntityName() {
		return ClientType.class.getSimpleName();
	}
}
