package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Batch;
import com.proface.api.repositories.BatchRepository;
import com.proface.api.services.IBatchService;

@Service
public class BatchService extends ProfaceService<BatchRepository, Batch, Integer, String> implements IBatchService {

	@Override
	public void save(Batch entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Batch entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return Batch.class.getSimpleName();
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(Batch entity, Batch repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
	}
}
