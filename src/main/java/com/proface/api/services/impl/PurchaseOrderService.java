package com.proface.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class PurchaseOrderService extends ProfaceValidationHelper<String> implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Override
	public Page<PurchaseOrder> findAll(Pageable pageable) {
		return purchaseOrderRepository.findAll(pageable);
	}

	@Override
	public PurchaseOrder findOne(Integer id) {
		Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);
		notExisting(id);
		return purchaseOrder.get();
	}

	@Override
	@Transactional
	public void save(PurchaseOrder entity) {
		entity.setId(0);
		duplicatedId(entity.getNativeId());
		purchaseOrderRepository.save(entity);
	}

	@Override
	@Transactional
	public void edit(Integer id, PurchaseOrder entity) {
		entity.setId(id);
		notExisting(id);
		duplicatedId(entity.getNativeId());
		purchaseOrderRepository.save(entity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		notExisting(id);
		purchaseOrderRepository.deleteById(id);
		
	}
	
	protected void duplicatedId(String nativeId) {
		if (purchaseOrderRepository.existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	protected void notExisting(int id) {
		if (!purchaseOrderRepository.existsById(id))
			super.notExisting();
	}
	
	protected String getEntityName() {
		return "La Orden de Compra";
	}

}
