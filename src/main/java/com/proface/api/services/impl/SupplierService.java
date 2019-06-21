package com.proface.api.services.impl;

import com.proface.api.entities.Country;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.Supplier;
import com.proface.api.entities.SupplierType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.repositories.SupplierRepository;
import com.proface.api.services.ISupplierService;
import com.proface.api.services.ISupplierTypeService;

@Service
public class SupplierService extends ProfaceService<SupplierRepository, Supplier, Integer, String>
		implements ISupplierService {

	@Autowired
	private ISupplierTypeService supplierTypeService;

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
		entity.setType(getTypeByCountry(entity.getCountry()));
	}

	@Override
	protected void filterEntity(Supplier supplier) {
		supplier.setPurchases(extractOnePurchaseOrder(supplier.getPurchases()));
	}

	private List<PurchaseOrder> extractOnePurchaseOrder(List<PurchaseOrder> purchases) {
		return purchases != null && purchases.size() > 0
				? Arrays.asList(purchases.stream().filter(p -> Objects.nonNull(p.getCreationDate()))
						.max(Comparator.comparing(PurchaseOrder::getCreationDate)).orElse(null))
				: null;
	}

	private SupplierType getTypeByCountry(Country country) {
		return country != null && country.getIso() == "PE" ? supplierTypeService.findOne("name:Nacional")
				: supplierTypeService.findOne("name:Internacional");
	}

}
