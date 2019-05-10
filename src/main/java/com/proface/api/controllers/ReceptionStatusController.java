package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.ReceptionStatus;
import com.proface.api.mappers.ReceptionStatusMapper;
import com.proface.api.models.ReceptionStatusModel;
import com.proface.api.services.IReceptionStatusService;

@RestController
@RequestMapping("api/receptionStatuses")
public class ReceptionStatusController extends
		BaseRestController<Integer, ReceptionStatus, ReceptionStatusModel, ReceptionStatusMapper, IReceptionStatusService> {

}
