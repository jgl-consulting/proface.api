package com.proface.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.proface.api.entities.Contacto;

@RepositoryRestResource(collectionResourceRel = "contacto", path = "contacto", excerptProjection = Contacto.ContactoView.class)
public interface ContactoRepository extends PagingAndSortingRepository<Contacto, String> {

}
