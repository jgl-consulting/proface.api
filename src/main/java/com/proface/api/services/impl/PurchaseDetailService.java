package com.proface.api.services.impl;

import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetail;
import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.services.IPurchaseDetailService;

@Service
public class PurchaseDetailService
		extends BaseService<PurchaseDetailRepository, PurchaseDetail, PurchaseDetailPK, String>
		implements IPurchaseDetailService {

	@Override
	public void save(PurchaseDetail entity) {
		PurchaseDetailPK id = new PurchaseDetailPK();
		id.setProductId(entity.getProduct() == null ? 0 : entity.getProduct().getId());
		id.setPurchaseId(entity.getPurchase() == null ? 0 : entity.getPurchase().getId());
		entity.setId(id);
		super.save(entity);
	}

	@Override
	public void edit(PurchaseDetailPK id, PurchaseDetail entity) {
		if (id == null) {
			id = new PurchaseDetailPK();
			id.setProductId(entity.getProduct() == null ? 0 : entity.getProduct().getId());
			id.setPurchaseId(entity.getPurchase() == null ? 0 : entity.getPurchase().getId());
		}
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return PurchaseDetail.class.getSimpleName();
	}

}
