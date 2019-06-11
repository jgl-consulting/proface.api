package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.Unit;
import com.proface.api.entities.UnitTrace;
import com.proface.api.repositories.UnitRepository;
import com.proface.api.services.IProductService;
import com.proface.api.services.IUnitService;
import com.proface.api.services.IUnitStatusService;

@Service
public class UnitService extends ProfaceService<UnitRepository, Unit, Integer, String> implements IUnitService {

	@Autowired
	private IProductService productService;

	@Autowired
	private IUnitStatusService unitStatusService;

	@Override
	public void save(Unit entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Unit entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return Unit.class.getSimpleName();
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId)) {
			super.duplicatedId(nativeId);
		}
	}

	@Override
	protected void compareEntity(Unit entity, Unit repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
		if (entity.getTraces() != null) {
			entity.getTraces().forEach(t -> t.setUnit(entity));
		}
	}

	@Override
	protected void prepareEntity(Unit entity) {
		if (entity.getStatus() == null) {
			entity.setStatus(unitStatusService.findOne("nativeId:D"));
		}
		if (entity.getTraces() == null) {
			entity.setTraces(new ArrayList<>());
		}
		if (entity.getTraces().isEmpty()) {
			UnitTrace trace = new UnitTrace();
			trace.setStatus(entity.getStatus());
			trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
			trace.setUnit(entity);
			entity.getTraces().add(trace);
		}
		switch (entity.getStatus().getNativeId()) {
		case "D":
			entity.getProduct().setTotalStock(entity.getProduct().getTotalStock() + 1);
			entity.getProduct().setAvaliableStock(entity.getProduct().getAvaliableStock() + 1);
			break;
		case "S":
			entity.getProduct().setAvaliableStock(entity.getProduct().getAvaliableStock() - 1);
			break;
		case "R":
			entity.getProduct().setTotalStock(entity.getProduct().getTotalStock() - 1);
			break;
		}
		productService.edit(entity.getProduct().getId(), entity.getProduct());
	}

	@Override
	protected void resetEntity(Unit entity) {
		if (entity.getStatus() != null) {
			switch (entity.getStatus().getNativeId()) {
			case "D":
				entity.getProduct().setTotalStock(entity.getProduct().getTotalStock() - 1);
				break;
			case "S":
				entity.getProduct().setAvaliableStock(entity.getProduct().getAvaliableStock() + 1);
				break;
			}
			productService.edit(entity.getProduct().getId(), entity.getProduct());
		}
	}

}
