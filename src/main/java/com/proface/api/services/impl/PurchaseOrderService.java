package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.PurchaseDetailPK;
import com.proface.api.entities.PurchaseOrder;
import com.proface.api.entities.PurchaseTrace;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseDetailService;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.services.IPurchaseStatusService;
import com.proface.api.services.IPurchaseTraceService;
import com.proface.api.util.ProfaceCurrencyExchanger;

@Service
public class PurchaseOrderService extends ProfaceService<PurchaseOrderRepository, PurchaseOrder, Integer, String>
		implements IPurchaseOrderService {

	@Autowired
	private IPurchaseDetailService purchaseDetailService;

	@Autowired
	private IPurchaseStatusService purchaseStatusService;

	@Autowired
	private IPurchaseTraceService purchaseTraceService;

	@Override
	public void save(PurchaseOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
		if (entity.getDetails() != null) {
			entity.getDetails().forEach(d -> {
				d.setId(new PurchaseDetailPK(d.getProduct() == null ? 0 : d.getProduct().getId(),
						entity == null ? 0 : entity.getId()));
				d.setPurchase(entity);
			});
			purchaseDetailService.saveAll(entity.getDetails());
		}
		if (entity.getTraces() == null) {
			PurchaseTrace trace = new PurchaseTrace();
			trace.setStatus(entity.getStatus());
			trace.setStatusDate(entity.getCreationDate());
			trace.setPurchase(entity);
			purchaseTraceService.save(trace);
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
		if (repositoryEntity.getStatus().getNativeId() != entity.getStatus().getNativeId()) {
			PurchaseTrace trace = new PurchaseTrace();
			trace.setStatus(entity.getStatus());
			trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
			trace.setPurchase(entity);
			purchaseTraceService.save(trace);
		}
	}

	@Override
	protected String getEntityName() {
		return PurchaseOrder.class.getSimpleName();
	}

	@Override
	protected void prepareEntity(PurchaseOrder entity) {
		if (entity.getCurrency() != null) {
			entity.setLocalTotal(ProfaceCurrencyExchanger.fromCurrencyToCurrency(entity.getCurrency().getId(), "PEN",
					entity.getTotal()));
		}
		if (entity.getCreationDate() == null) {
			entity.setCreationDate(LocalDate.now(ZoneId.systemDefault()));
		}
		if (entity.getStatus() == null) {
			entity.setStatus(purchaseStatusService.findOne("nativeId:CR"));
		}
	}

}
