package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Client;
import com.proface.api.mappers.ClientMapper;
import com.proface.api.models.ClientModel;
import com.proface.api.services.IClientService;

@RestController
@RequestMapping("api/clients")
public class ClientController extends ProfaceController<Integer, Client, ClientModel, ClientMapper, IClientService> {

}
