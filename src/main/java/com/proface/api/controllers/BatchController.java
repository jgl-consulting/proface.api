package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Batch;
import com.proface.api.mappers.BatchMapper;
import com.proface.api.models.BatchModel;
import com.proface.api.services.IBatchService;

@RestController
@RequestMapping("api/batches")
public class BatchController extends ProfaceController<Integer, Batch, BatchModel, BatchMapper, IBatchService> {

}
