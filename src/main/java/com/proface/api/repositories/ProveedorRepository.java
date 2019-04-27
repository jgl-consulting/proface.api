package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.Proveedor;

@RepositoryRestResource(collectionResourceRel = "proveedor", path = "proveedor", excerptProjection = Proveedor.ProveedorView.class)
public interface ProveedorRepository extends PagingAndSortingRepository<Proveedor, String> {

}
