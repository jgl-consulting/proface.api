package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.ClientType;
import com.proface.api.mappers.ClientTypeMapper;
import com.proface.api.models.ClientTypeModel;
import com.proface.api.services.IClientTypeService;

@RestController
@RequestMapping("api/clientTypes")
public class ClientTypeController
		extends ProfaceController<Integer, ClientType, ClientTypeModel, ClientTypeMapper, IClientTypeService> {

}
