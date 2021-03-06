package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.Cuenta;

@RepositoryRestResource(collectionResourceRel = "cuenta", path = "cuenta", excerptProjection = Cuenta.CuentaView.class)
public interface CuentaRepository extends PagingAndSortingRepository<Cuenta, String>{

}
