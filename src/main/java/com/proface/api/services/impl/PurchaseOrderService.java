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

@Service
public class PurchaseOrderService implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Override
	public Page<PurchaseOrder> findAll(Pageable pageable) {
		return purchaseOrderRepository.findAll(pageable);
	}

	@Override
	public Optional<PurchaseOrder> findOne(Integer id) {
		return purchaseOrderRepository.findById(id);
	}
	
	@Override
	public boolean exists(Integer id) {
		return purchaseOrderRepository.existsById(id);
	}

	@Override
	@Transactional
	public void save(PurchaseOrder purchaseOrder) {
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	@Transactional
	public void edit(Integer id, PurchaseOrder purchaseOrder) {
		purchaseOrder.setId(id);
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		purchaseOrderRepository.deleteById(id);
		
	}

}
