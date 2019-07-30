package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Client;
import com.proface.api.repositories.ClientRepository;
import com.proface.api.services.IClientService;

@Service
public class ClientService extends ProfaceService<ClientRepository, Client, Integer, String> implements IClientService {

	@Override
	public void save(Client entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Client entity) {
		entity.setId(0);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return Client.class.getSimpleName();
	}
}
