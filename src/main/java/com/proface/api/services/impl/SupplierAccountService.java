package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Supplier;
import com.proface.api.entities.SupplierAccount;
import com.proface.api.repositories.SupplierAccountRepository;
import com.proface.api.services.ISupplierAccountService;

@Service
public class SupplierAccountService extends BaseService<SupplierAccountRepository, SupplierAccount, Integer, String>
		implements ISupplierAccountService {

	@Override
	public void save(SupplierAccount entity) {
		entity.setId(0);
		duplicatedId(entity.getCci());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SupplierAccount entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByCci(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(SupplierAccount entity, SupplierAccount repositoryEntity) {
		if (entity.getCci() != null) {
			if (!entity.getCci().equals(repositoryEntity.getCci())) {
				duplicatedId(entity.getCci());
			}
		} else {
			entity.setCci(repositoryEntity.getCci());
		}
	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}

}
