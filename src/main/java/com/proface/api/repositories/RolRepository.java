package com.proface.api.repositories;

import com.proface.api.entities.Rol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@Secured("ADMIN")
@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {
}
