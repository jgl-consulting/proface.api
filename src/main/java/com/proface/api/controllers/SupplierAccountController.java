package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.SupplierAccount;
import com.proface.api.mappers.SupplierAccountMapper;
import com.proface.api.models.SupplierAccountModel;
import com.proface.api.services.ISupplierAccountService;

@RestController
@RequestMapping("api/supplierAccounts")
public class SupplierAccountController extends
		ProfaceController<Integer, SupplierAccount, SupplierAccountModel, SupplierAccountMapper, ISupplierAccountService> {

}
