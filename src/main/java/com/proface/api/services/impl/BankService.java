package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Bank;
import com.proface.api.repositories.BankRepository;
import com.proface.api.services.IBankService;

@Service
public class BankService extends BaseService<BankRepository, Bank, Integer, Integer> implements IBankService {

	@Override
	public void save(Bank entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Bank entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return Bank.class.getSimpleName();
	}
	
}
