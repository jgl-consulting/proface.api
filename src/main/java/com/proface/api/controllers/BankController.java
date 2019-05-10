package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Bank;
import com.proface.api.mappers.BankMapper;
import com.proface.api.models.BankModel;
import com.proface.api.services.IBankService;

@RestController
@RequestMapping("api/banks")
public class BankController extends BaseRestController<Integer, Bank, BankModel, BankMapper, IBankService> {

}
