package com.proface.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.Supplier;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseOrderService;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderRepository, PurchaseOrder, Integer, String>
		implements IPurchaseOrderService {

	@Autowired
	private PurchaseDetailRepository purchaseDetailRepository;
	
	@Override
	public void save(PurchaseOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		PurchaseOrder persistedEntity = getRepository().save(entity);
		entity.getDetails().forEach(detail -> {
			PurchaseDetailPK id = new PurchaseDetailPK();
			id.setProductId(detail.getProduct() == null ? 0 : detail.getProduct().getId());
			id.setPurchaseId(persistedEntity == null ? 0 : persistedEntity.getId());
			detail.setId(id);
		});
		purchaseDetailRepository.saveAll(entity.getDetails());
	}

	@Override
	public void edit(Integer id, PurchaseOrder entity) {
		entity.setId(id);
		super.edit(id, entity);
	}

	@Override
	protected void duplicatedId(String nativeId) {
		if (super.getRepository().existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}
	
	@Override
	protected void compareEntity(PurchaseOrder entity, PurchaseOrder repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else
			entity.setNativeId(repositoryEntity.getNativeId());
		if (entity.getCreationDate() == null)
			entity.setCreationDate(repositoryEntity.getCreationDate());
		if (entity.getStatus() == null)
			entity.setStatus(repositoryEntity.getStatus());
	}

	@Override
	protected String getEntityName() {
		return Supplier.class.getSimpleName();
	}

}
