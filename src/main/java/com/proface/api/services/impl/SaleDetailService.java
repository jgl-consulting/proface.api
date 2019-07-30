package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleDetail;
import com.proface.api.entities.SaleDetailPK;
import com.proface.api.repositories.SaleDetailRepository;
import com.proface.api.services.ISaleDetailService;

@Service
public class SaleDetailService extends ProfaceService<SaleDetailRepository, SaleDetail, SaleDetailPK, String>
		implements ISaleDetailService {

	@Override
	public void save(SaleDetail entity) {
		setId(entity);
		super.save(entity);
	}

	@Override
	public void edit(SaleDetailPK id, SaleDetail entity) {
		entity.setId(id);
		setId(entity);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleDetail.class.getSimpleName();
	}

	@Override
	protected void setId(SaleDetail entity) {
		if (entity.getId() == null) {
			entity.setId(new SaleDetailPK(entity.getSale() == null ? 0 : entity.getSale().getId(),
					entity.getProduct() == null ? 0 : entity.getProduct().getId()));
		}
	}

}
