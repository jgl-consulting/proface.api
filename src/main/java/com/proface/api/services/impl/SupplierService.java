package com.proface.api.services.impl;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.Supplier;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.repositories.SupplierTypeRepository;
import com.proface.api.services.ISupplierService;

@Service
public class SupplierService extends BaseService<SupplierRepository, Supplier, Integer, String>
		implements ISupplierService {

	@Autowired
	private SupplierTypeRepository supplierTypeRepository;

	@Override
	public void save(Supplier entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, Supplier entity) {
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
	protected void compareEntity(Supplier entity, Supplier repositoryEntity) {
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
		return Supplier.class.getSimpleName();
	}

	@Override
	protected void prepareEntity(Supplier entity) {
		entity.setType(entity.getCountry() != null && entity.getCountry().getId() == 161
				? supplierTypeRepository.findByName("Nacional").orElse(null)
				: supplierTypeRepository.findByName("Internacional").orElse(null));
	}

	@Override
	protected void filterEntity(Supplier supplier) {
		if (supplier.getPurchases() != null && supplier.getPurchases().size() > 0) {
			supplier.setPurchases(Arrays.asList(supplier.getPurchases().stream()
					.filter(p -> Objects.nonNull(p.getCreationDate())).collect(Collectors.toList()).stream()
					.max(Comparator.comparing(PurchaseOrder::getCreationDate)).orElse(null)));
		}
	}

}
