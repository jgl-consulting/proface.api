package com.proface.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proface.api.entities.Location;
import com.proface.api.mappers.LocationMapper;
import com.proface.api.models.LocationModel;
import com.proface.api.services.ILocationService;

@RestController
@RequestMapping("api/locations")
public class LocationController
		extends ProfaceController<Integer, Location, LocationModel, LocationMapper, ILocationService> {

}
