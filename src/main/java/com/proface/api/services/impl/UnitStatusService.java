package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.UnitStatus;
import com.proface.api.repositories.UnitStatusRepository;
import com.proface.api.services.IUnitStatusService;

@Service
public class UnitStatusService extends ProfaceService<UnitStatusRepository, UnitStatus, Integer, String>
		implements IUnitStatusService {

	@Override
	public void save(UnitStatus entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, UnitStatus entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return UnitStatus.class.getSimpleName();
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(UnitStatus entity, UnitStatus repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
	}

}
