package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.Direccion;

@RepositoryRestResource(collectionResourceRel = "direccion", path = "direccion", excerptProjection = Direccion.DireccionView.class)
public interface DireccionRepository extends PagingAndSortingRepository<Direccion, String> {

}
