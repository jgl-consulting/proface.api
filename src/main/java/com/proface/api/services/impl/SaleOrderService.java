package com.proface.api.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.SaleDetailPK;
import com.proface.api.entities.SaleOrder;
import com.proface.api.entities.SaleTrace;
import com.proface.api.exceptions.customs.ProfaceInvalidStatusException;
import com.proface.api.repositories.SaleOrderRepository;
import com.proface.api.services.ISaleDetailService;
import com.proface.api.services.ISaleOrderService;
import com.proface.api.services.ISaleStatusService;
import com.proface.api.services.ISaleTraceService;
import com.proface.api.services.IUserService;

@Service
public class SaleOrderService extends ProfaceService<SaleOrderRepository, SaleOrder, Integer, String>
		implements ISaleOrderService {

	@Autowired
	private ISaleDetailService saleDetailService;
	
	@Autowired
	private ISaleStatusService saleStatusService;
	
	@Autowired
	private ISaleTraceService saleTraceService;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public void save(SaleOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		super.save(entity);
		if (entity.getDetails() != null) {
			entity.getDetails().forEach(d -> {
				d.setId(new SaleDetailPK(d.getProduct() == null ? 0 : d.getProduct().getId(),
						entity == null ? 0 : entity.getId()));
				d.setSale(entity);
			});
			saleDetailService.saveAll(entity.getDetails());
		}
		if (entity.getTraces() == null) {
			SaleTrace trace = new SaleTrace();
			trace.setStatus(entity.getStatus());
			trace.setStatusDate(entity.getCreationDate());
			trace.setSale(entity);
			saleTraceService.save(trace);
		}
	}

	@Override
	public void edit(Integer id, SaleOrder entity) {
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
	protected void compareEntity(SaleOrder entity, SaleOrder repositoryEntity) {
		if (entity.getNativeId() != null) {
			if (!entity.getNativeId().equals(repositoryEntity.getNativeId())) {
				duplicatedId(entity.getNativeId());
			}
		} else {
			entity.setNativeId(repositoryEntity.getNativeId());
		}
		if (entity.getStatus() != null) {
			if (entity.getStatus().getOrder() < repositoryEntity.getStatus().getOrder()) {
				throw new ProfaceInvalidStatusException(
						String.format("No se puede actualizar del estado %s al estado %s",
								repositoryEntity.getStatus().getDescription(), entity.getStatus().getDescription()));
			}
			if (repositoryEntity.getStatus().getId() != entity.getStatus().getId()) {
				SaleTrace trace = new SaleTrace();
				trace.setStatus(entity.getStatus());
				trace.setStatusDate(LocalDate.now(ZoneId.systemDefault()));
				trace.setSale(entity);
				saleTraceService.save(trace);
			}
		}
	}

	@Override
	protected String getEntityName() {
		return SaleOrder.class.getSimpleName();
	}
	
	@Override
	protected void prepareEntity(SaleOrder entity) {
		if (entity.getUser() != null) {
			entity.setUser(userService.findOne(entity.getUser().getId()));
		}
		if (entity.getCreationDate() == null) {
			entity.setCreationDate(LocalDate.now(ZoneId.systemDefault()));
		}
		if (entity.getStatus() == null) {
			entity.setStatus(saleStatusService.findOne("nativeId:CR"));
		}
	}

}
