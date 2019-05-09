package com.proface.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proface.api.entities.PurchaseOrder;
import com.proface.api.repositories.PurchaseOrderRepository;
import com.proface.api.services.IPurchaseOrderService;
import com.proface.api.util.CollectionConverter;
import com.proface.api.validations.ProfaceValidationHelper;

@Service
public class PurchaseOrderService extends ProfaceValidationHelper<String> implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private CollectionConverter<PurchaseOrder> converter;
	
	@Override
	public Page<PurchaseOrder> findAll(Pageable pageable) {
		return purchaseOrderRepository.findAll(pageable);
	}

	@Override
	public List<PurchaseOrder> findAll() {
		return converter.iterableToList(purchaseOrderRepository.findAll());
	}
	
	@Override
	public PurchaseOrder findOne(Integer id) {
		Optional<PurchaseOrder> entity = purchaseOrderRepository.findById(id);
		if(!entity.isPresent())
			notExisting();
		return entity.get();
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
	
	@Override
	protected void duplicatedId(String nativeId) {
		if (purchaseOrderRepository.existsByNativeId(nativeId))
			super.duplicatedId(nativeId);
	}

	protected void notExisting(int id) {
		if (!purchaseOrderRepository.existsById(id))
			super.notExisting();
	}
	
	@Override
	protected String getEntityName() {
		return PurchaseOrder.class.getSimpleName();
	}

}
