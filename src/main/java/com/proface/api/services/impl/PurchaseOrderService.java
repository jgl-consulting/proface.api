package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.PurchaseTrace;
import com.proface.api.entities.Supplier;
import com.proface.api.repositories.PurchaseDetailRepository;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.repositories.PurchaseStatusRepository;
import com.proface.api.services.IPurchaseOrderService;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrderRepository, PurchaseOrder, Integer, String>
		implements IPurchaseOrderService {

	@Autowired
	private PurchaseDetailRepository purchaseDetailRepository;

	@Autowired
	private PurchaseStatusRepository purchaseStatusRepository;

	@Override
	public void save(PurchaseOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		PurchaseOrder persistedEntity = getRepository().save(entity);
		if (entity.getDetails() != null) {
			entity.getDetails()
					.forEach(d -> d.setId(new PurchaseDetailPK(d.getProduct() == null ? 0 : d.getProduct().getId(),
							persistedEntity == null ? 0 : persistedEntity.getId())));
			purchaseDetailRepository.saveAll(entity.getDetails());
		}
	}

	@Override
	public void edit(Integer id, PurchaseOrder entity) {
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
	protected void compareEntity(PurchaseOrder entity, PurchaseOrder repositoryEntity) {
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
	public Page<PurchaseOrder> findAll(Pageable pageable, int supplierId) {
		return super.getRepository().findBySupplierId(pageable, supplierId);
	}

	@Override
	protected void prepareEntity(PurchaseOrder purchaseOrder) {
		if (purchaseOrder.getStatus() != null) {
			PurchaseTrace trace = new PurchaseTrace();
			trace.setPurchase(purchaseOrder);
			trace.setStatus(purchaseOrder.getStatus());
			trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
			purchaseOrder.setTraces(Arrays.asList());
		} else {
			purchaseOrder.setStatus(purchaseStatusRepository.findByNativeId("CR").orElse(null));
		}
		if (purchaseOrder.getStatus().getNativeId() == "CR" && purchaseOrder.getCreationDate() == null) {
			purchaseOrder.setCreationDate(LocalDate.now(ZoneId.systemDefault()));
		}
	}

}
