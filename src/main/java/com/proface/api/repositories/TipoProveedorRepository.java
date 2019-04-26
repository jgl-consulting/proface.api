package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.TipoProveedor;

@RepositoryRestResource(collectionResourceRel = "tipoProveedor", path = "tipoProveedor", excerptProjection = TipoProveedor.TipoProveedorView.class)
public interface TipoProveedorRepository extends PagingAndSortingRepository<TipoProveedor, Integer> {
	
}
