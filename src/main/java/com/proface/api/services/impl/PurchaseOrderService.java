package com.proface.api.services.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.PurchaseStatus;
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
		getDateByStatus(entity);
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
		getDateByStatus(entity);
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

	@Override
	public Page<PurchaseOrder> findAll(Pageable pageable, int supplierId) {
		return super.getRepository().findBySupplierId(pageable, supplierId);
	}

	private void getDateByStatus(PurchaseOrder purchaseOrder) {
		if (purchaseOrder.getStatus() != null) {
			Optional<PurchaseStatus> status = purchaseStatusRepository.findById(purchaseOrder.getStatus().getId());
			if (status.isPresent()) {
				switch (status.get().getNativeId()) {
				case "E":
					if (purchaseOrder.getCreationDate() == null)
						purchaseOrder.setCreationDate(LocalDate.now());
					break;
				case "C":
					if (purchaseOrder.getCancellationDate() == null)
						purchaseOrder.setCancellationDate(LocalDate.now());
					break;
				case "P":
					if (purchaseOrder.getQuotationDate() == null)
						purchaseOrder.setQuotationDate(LocalDate.now());
					break;
				case "F":
					if (purchaseOrder.getBillingDate() == null)
						purchaseOrder.setBillingDate(LocalDate.now());
					break;
				case "R":
					if (purchaseOrder.getReceptionDate() == null)
						purchaseOrder.setReceptionDate(LocalDate.now());
					break;
				}
			}
		}
	}

}
