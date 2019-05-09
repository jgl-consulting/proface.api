package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SupplierContact;
import com.proface.api.mappers.SupplierContactMapper;
import com.proface.api.models.SupplierContactModel;
import com.proface.api.services.ISupplierContactService;

@RestController
@RequestMapping("api/supplierContacts")
public class SupplierContactController extends
		BaseRestController<Integer, SupplierContact, SupplierContactModel, SupplierContactMapper, ISupplierContactService> {
}
