package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleOrder;
import com.proface.api.repositories.SaleOrderRepository;
import com.proface.api.services.ISaleOrderService;

@Service
public class SaleOrderService extends ProfaceService<SaleOrderRepository, SaleOrder, Integer, String>
		implements ISaleOrderService {

	@Override
	public void save(SaleOrder entity) {
		entity.setId(0);
		super.save(entity);
	}

	@Override
	public void edit(Integer id, SaleOrder entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleOrder.class.getSimpleName();
	}

}
