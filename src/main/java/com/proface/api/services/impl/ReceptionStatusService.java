package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.ReceptionStatus;
import com.proface.api.repositories.ReceptionStatusRepository;
import com.proface.api.services.IReceptionStatusService;

@Service
public class ReceptionStatusService extends BaseService<ReceptionStatusRepository, ReceptionStatus, Integer, String>
		implements IReceptionStatusService {

	@Override
	public void save(ReceptionStatus entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, ReceptionStatus entity) {
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
	protected void compareEntity(ReceptionStatus entity, ReceptionStatus repositoryEntity) {
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
		return ReceptionStatus.class.getSimpleName();
	}
	
}
