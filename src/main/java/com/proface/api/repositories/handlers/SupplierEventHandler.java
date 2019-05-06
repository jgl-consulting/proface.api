package com.proface.api.repositories.handlers;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.proface.api.entities.Supplier;

@Component
@RepositoryEventHandler(Supplier.class)
public class SupplierEventHandler {

	 @HandleBeforeCreate
	 public void handleSupplierBeforeCreate(Supplier supplier) {
		 supplier.getContacts().forEach(contact -> contact.setSupplier(supplier));
	 }
	 
}
