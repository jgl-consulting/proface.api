package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.PurchaseTrace;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseDetailService;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.services.IPurchaseStatusService;
import com.proface.api.util.ProfaceCurrencyExchanger;

@Service
public class PurchaseOrderService extends ProfaceService<PurchaseOrderRepository, PurchaseOrder, Integer, String>
		implements IPurchaseOrderService {

	@Autowired
	private IPurchaseDetailService purchaseDetailService;

	@Autowired
	private IPurchaseStatusService purchaseStatusService;

	@Override
	public void save(PurchaseOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		PurchaseOrder persistedEntity = getRepository().save(entity);
		if (entity.getDetails() != null) {
			entity.getDetails()
					.forEach(d -> d.setId(new PurchaseDetailPK(d.getProduct() == null ? 0 : d.getProduct().getId(),
							persistedEntity == null ? 0 : persistedEntity.getId())));
			purchaseDetailService.saveAll(entity.getDetails());
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
		if (entity.getTraces() != null) {
			entity.getTraces().forEach(t -> t.setPurchase(entity));
		}
	}

	@Override
	protected String getEntityName() {
		return PurchaseOrder.class.getSimpleName();
	}

	@Override
	public Page<PurchaseOrder> findAll(Pageable pageable, int supplierId) {
		return super.getRepository().findBySupplierId(pageable, supplierId);
	}

	@Override
	protected void prepareEntity(PurchaseOrder entity) {
		entity.setLocalTotal(ProfaceCurrencyExchanger.fromCurrencyToCurrency(entity.getCurrency().getId(), "PEN",
				entity.getTotal()));
		if (entity.getCreationDate() == null) {
			entity.setCreationDate(LocalDate.now(ZoneId.systemDefault()));
		}
		if (entity.getStatus() == null) {
			entity.setStatus(purchaseStatusService.findOne("nativeId:CR"));
		}
		if (entity.getTraces() == null) {
			entity.setTraces(new ArrayList<>());
		}
		if (entity.getTraces().isEmpty()) {
			PurchaseTrace trace = new PurchaseTrace();
			trace.setStatus(entity.getStatus());
			trace.setStatusDate(entity.getCreationDate());
			trace.setPurchase(entity);
			entity.getTraces().add(trace);
		}
	}

}
