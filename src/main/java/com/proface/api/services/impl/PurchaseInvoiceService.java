package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseInvoice;
import com.proface.api.repositories.PurchaseInvoiceRepository;
import com.proface.api.services.IPurchaseInvoiceService;

@Service
public class PurchaseInvoiceService extends BaseService<PurchaseInvoiceRepository, PurchaseInvoice, Integer, String>
		implements IPurchaseInvoiceService {

	@Override
	public void save(PurchaseInvoice entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
	}

	@Override
	public void edit(Integer id, PurchaseInvoice entity) {
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
	protected void compareEntity(PurchaseInvoice entity, PurchaseInvoice repositoryEntity) {
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
		return PurchaseInvoice.class.getSimpleName();
	}

}
