package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseStatus;
import com.proface.api.repositories.PurchaseStatusRepository;
import com.proface.api.services.IPurchaseStatusService;

@Service
public class PurchaseStatusService extends BaseService<PurchaseStatusRepository, PurchaseStatus, Integer, String>
		implements IPurchaseStatusService {

	@Override
	public void save(PurchaseStatus entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, PurchaseStatus entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(PurchaseStatus entity, PurchaseStatus repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
	}

	@Override
	protected String getEntityName() {
		return PurchaseStatus.class.getSimpleName();
	}

}
