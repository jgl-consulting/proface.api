package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.Batch;
import com.proface.api.repositories.BatchRepository;
import com.proface.api.services.IBatchService;
import com.proface.api.services.IUnitService;

@Service
public class BatchService extends ProfaceService<BatchRepository, Batch, Integer, String> implements IBatchService {

	@Autowired
	private IUnitService unitService;
	
	@Override
	public void save(Batch entity) {
		entity.setId(0);
		super.save(entity);
		if(entity.getUnits() != null) {
			entity.getUnits().forEach(u -> {
				u.setBatch(entity);
				unitService.save(u);
			});
		}
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
	
	@Override
	protected void prepareEntity(Batch entity) {
		if (entity.getEntryDate() == null) {
			entity.setEntryDate(LocalDate.now(ZoneId.systemDefault()));
		}
	}
	
	@Override
	protected void resetEntity(Batch entity) {
		if (entity.getUnits() != null || !entity.getUnits().isEmpty()) {
			entity.getUnits().forEach(u -> unitService.delete(u.getId()));
		}
	}
}
