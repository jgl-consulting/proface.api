package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.Location;
import com.proface.api.repositories.LocationRepository;
import com.proface.api.services.ILocationService;

@Service
public class LocationService extends ProfaceService<LocationRepository, Location, Integer, String>
		implements ILocationService {

	@Override
	public void save(Location entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Location entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return Location.class.getSimpleName();
	}
	
	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(Location entity, Location repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
	}

}
