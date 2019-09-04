package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.Product;
import com.proface.api.entities.Unit;
import com.proface.api.entities.UnitStatus;
import com.proface.api.entities.UnitTrace;
import com.proface.api.repositories.UnitRepository;
import com.proface.api.services.IProductService;
import com.proface.api.services.IUnitService;
import com.proface.api.services.IUnitStatusService;
import com.proface.api.services.IUnitTraceService;

@Service
public class UnitService extends ProfaceService<UnitRepository, Unit, Integer, String> implements IUnitService {

	@Autowired
	private IProductService productService;

	@Autowired
	private IUnitStatusService unitStatusService;

	@Autowired
	private IUnitTraceService unitTraceService;

	@Override
	public void save(Unit entity) {
		entity.setId(0);
		super.save(entity);
		if (entity.getProduct() != null) {
			Product product = productService.findOne(entity.getProduct().getId());
			product.setTotalStock(product.getTotalStock() + 1);
			product.setAvaliableStock(product.getAvaliableStock() + 1);
			productService.edit(product.getId(), product);
		}
		if (entity.getTraces() == null) {
			UnitTrace trace = new UnitTrace();
			trace.setStatus(entity.getStatus());
			if (entity.getBatch() != null) {
				trace.setStatusDate(entity.getBatch().getEntryDate());
			} else {
				trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
			}
			trace.setUnit(entity);
			unitTraceService.save(trace);
		}
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
		if (entity.getStatus() != null) {
			if (repositoryEntity.getStatus().getId() == entity.getStatus().getId()) {
				UnitTrace trace = new UnitTrace();
				trace.setStatus(entity.getStatus());
				trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
				trace.setUnit(entity);
				unitTraceService.save(trace);
			}
		}
		if (entity.getProduct() != null) {
			if (repositoryEntity.getProduct().getId() != entity.getProduct().getId()) {
				Product product = repositoryEntity.getProduct();
				if (repositoryEntity.getStatus().getNativeId().equalsIgnoreCase("D")) {
					product.setAvaliableStock(product.getAvaliableStock() - 1);					
				}
				product.setTotalStock(product.getTotalStock() - 1);
				productService.edit(product.getId(), product);
				product = productService.findOne(entity.getProduct().getId());				
				product.setTotalStock(product.getTotalStock() + 1);
				switch (entity.getStatus().getNativeId()) {
				case "D":
					product.setAvaliableStock(product.getAvaliableStock() + 1);
					break;
				case "R":
					product.setTotalStock(product.getTotalStock() - 1);
					break;
				}
				productService.edit(product.getId(), product);
			} else {
				Product product = productService.findOne(entity.getProduct().getId());
				editProductStockByStatus(product, entity.getStatus(), repositoryEntity.getStatus());
				productService.edit(product.getId(), product);
			}
		}
	}

	@Override
	protected void prepareEntity(Unit entity) {
		if (entity.getStatus() == null) {
			entity.setStatus(unitStatusService.findOne("nativeId:D"));
		}
	}

	@Override
	protected void resetEntity(Unit entity) {
		if (entity.getStatus() != null) {
			switch (entity.getStatus().getNativeId()) {
			case "D":
				entity.getProduct().setTotalStock(entity.getProduct().getTotalStock() - 1);
				entity.getProduct().setAvaliableStock(entity.getProduct().getAvaliableStock() - 1);
				break;
			case "S":
				entity.getProduct().setTotalStock(entity.getProduct().getTotalStock() - 1);
				break;
			case "R":
				return;
			}
			productService.edit(entity.getProduct().getId(), entity.getProduct());
		}
	}

	private void editProductStockByStatus(Product product, UnitStatus newStatus, UnitStatus oldStatus) {
		int avaliableStock = product.getAvaliableStock();
		int totalStock = product.getTotalStock();
		oldStatus = unitStatusService.findOne(oldStatus.getId());
		switch (oldStatus.getNativeId()) {
		case "D":
			if (newStatus.getNativeId().equalsIgnoreCase("R")) {
				product.setTotalStock(totalStock - 1);
			}
			product.setAvaliableStock(avaliableStock - 1);
			break;
		case "S":
			switch (newStatus.getNativeId()) {
			case "D":
				product.setAvaliableStock(avaliableStock + 1);
				break;
			case "R":
				product.setTotalStock(totalStock - 1);
				break;
			}
			break;
		case "R":
			if (newStatus.getNativeId().equalsIgnoreCase("D")) {
				product.setAvaliableStock(avaliableStock + 1);
			}
			product.setTotalStock(totalStock + 1);
			break;
		}
	}

}
