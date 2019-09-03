package com.proface.api.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proface.api.entities.Product;
import com.proface.api.entities.SaleDetail;
import com.proface.api.entities.SaleDetailPK;
import com.proface.api.entities.SaleOrder;
import com.proface.api.entities.Unit;
import com.proface.api.exceptions.customs.ProfaceNotAvaliableException;
import com.proface.api.repositories.SaleDetailRepository;
import com.proface.api.services.IProductService;
import com.proface.api.services.ISaleDetailService;
import com.proface.api.services.ISaleOrderService;
import com.proface.api.services.IUnitService;
import com.proface.api.services.IUnitStatusService;

@Service
public class SaleDetailService extends ProfaceService<SaleDetailRepository, SaleDetail, SaleDetailPK, String>
		implements ISaleDetailService {

	@Autowired
	private ISaleOrderService saleOrderService;

	@Autowired
	private IUnitService unitService;

	@Autowired
	private IUnitStatusService unitStatusService;
	
	@Autowired
	private IProductService productService;

	@Override
	public void save(SaleDetail entity) {
		setId(entity);
		super.save(entity);
	}

	@Override
	public void edit(SaleDetailPK id, SaleDetail entity) {
		entity.setId(id);
		setId(entity);
		super.edit(id, entity);
	}

	@Override
	protected String getEntityName() {
		return SaleDetail.class.getSimpleName();
	}

	@Override
	protected void prepareEntity(SaleDetail entity) {
		if (entity.getProduct() != null) {
			Product product = productService.findOne(entity.getProduct().getId());
			int avaliableQuantity = unitService.findAll("status.nativeId:D,¬product.id:" + product.getId()).size();
			if (entity.getQuantity() > avaliableQuantity) {
				throw new ProfaceNotAvaliableException(
						String.format("El producto %s no tiene disponible la cantidad %s solicitada.",
								product.getName(), entity.getQuantity()));
			}
		}
		entity.setSalePrice(entity.getQuantity() * entity.getUnitPrice());
		entity.setLocalPrice(entity.getSalePrice() - entity.getDisscount());
		if (entity.getSale() != null) {
			SaleOrder sale = saleOrderService.findOne(entity.getSale().getId());
			sale.setLocalTotal(sale.getLocalTotal() + entity.getLocalPrice());
			sale.setDetails(null);
			saleOrderService.edit(sale.getId(), sale);
		}
		if (entity.getProduct() != null) {
			List<Unit> units = unitService.findAll("status.nativeId:D,¬product.id:" + entity.getProduct().getId()).stream()
					.filter(u -> Objects.nonNull(u.getBatch()))
					.sorted(Comparator.comparing(Unit::getBatch, (b1, b2) -> {
						return b1.getEntryDate().compareTo(b2.getEntryDate());
					})).limit(entity.getQuantity()).collect(Collectors.toList());
			units.forEach(u -> {
				u.setStatus(unitStatusService.findOne("nativeId:S"));
				unitService.edit(u.getId(), u);
			});
		}
	}

	@Override
	protected void setId(SaleDetail entity) {
		if (entity.getId() == null) {
			entity.setId(new SaleDetailPK(entity.getProduct() == null ? 0 : entity.getProduct().getId(),
					entity.getSale() == null ? 0 : entity.getSale().getId()));
		}
	}

	@Override
	protected void compareEntity(SaleDetail entity, SaleDetail repositoryEntity) {
		double totalVariation = entity.getLocalPrice() - repositoryEntity.getLocalPrice();
		if (entity.getSale() != null) {
			SaleOrder sale = saleOrderService.findOne(entity.getSale().getId());
			sale.setLocalTotal(repositoryEntity.getSale().getLocalTotal() + totalVariation - entity.getLocalPrice());
			saleOrderService.edit(sale.getId(), sale);
		}
	}

	@Override
	protected void resetEntity(SaleDetail entity) {
		if (entity.getSale() != null) {
			SaleOrder sale = saleOrderService.findOne(entity.getSale().getId());
			sale.setLocalTotal(sale.getLocalTotal() - entity.getLocalPrice());
			saleOrderService.edit(sale.getId(), sale);
		}
		if (entity.getProduct() != null) {
			List<Unit> units = unitService.findAll("status.nativeId:S,¬product.id:" + entity.getProduct().getId())
					.stream().filter(u -> Objects.nonNull(u.getBatch()))
					.sorted(Comparator.comparing(Unit::getBatch, (b1, b2) -> {
						return b1.getEntryDate().compareTo(b2.getEntryDate());
					}).reversed()).limit(entity.getQuantity()).collect(Collectors.toList());
			units.forEach(u -> {
				u.setStatus(unitStatusService.findOne("nativeId:D"));
				unitService.edit(u.getId(), u);
			});
		}
	}

}
