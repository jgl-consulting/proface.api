package com.proface.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.exceptions.customs.ProfaceDuplicatedIdException;
import com.proface.api.exceptions.customs.ProfaceNotExistingException;
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
	public PurchaseOrder findOne(Integer id) {
		Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);
		if(!purchaseOrder.isPresent())
			throw new ProfaceNotExistingException("La orden de compra no ha sido registrada anteriormente.");
		return purchaseOrder.get();
	}

	@Override
	@Transactional
	public void save(PurchaseOrder purchaseOrder) {
		purchaseOrder.setId(0);
		if(purchaseOrderRepository.existsByNativeId(purchaseOrder.getNativeId()))
			throw new ProfaceDuplicatedIdException(String.format(
					"La orden de compra con identificador %s ya ha sido registrada anteriormente.", purchaseOrder.getNativeId()));
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	@Transactional
	public void edit(Integer id, PurchaseOrder purchaseOrder) {
		purchaseOrder.setId(id);
		if(!purchaseOrderRepository.existsById(purchaseOrder.getId()))
			throw new ProfaceNotExistingException("La orden de compra no ha sido registrada anteriormente.");
		if(purchaseOrderRepository.existsByNativeId(purchaseOrder.getNativeId()))
			throw new ProfaceDuplicatedIdException(String.format(
					"La orden de compra con identificador %s ya ha sido registrada anteriormente.", purchaseOrder.getNativeId()));
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		if(!purchaseOrderRepository.existsById(id))
			throw new ProfaceNotExistingException("La orden de compra no ha sido registrada anteriormente.");
		purchaseOrderRepository.deleteById(id);
		
	}

}
