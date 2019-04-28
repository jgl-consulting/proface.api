package com.proface.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import com.proface.api.entities.Usuario;

@Secured("ADMIN")
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long>{

    Page<Usuario> findAllByUsernameContains(Pageable pageable, @Param("username") String username);
}


