package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleInvoice;
import com.proface.api.repositories.SaleInvoiceRepository;
import com.proface.api.services.ISaleInvoiceService;

@Service
public class SaleInvoiceService extends ProfaceService<SaleInvoiceRepository, SaleInvoice, Integer, String>
		implements ISaleInvoiceService {

	@Override
	public void save(SaleInvoice entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SaleInvoice entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleInvoice.class.getSimpleName();
	}
}
