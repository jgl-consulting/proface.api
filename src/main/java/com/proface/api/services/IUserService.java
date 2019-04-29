package com.proface.api.services;

import com.proface.api.entities.Usuario;

import java.util.Optional;

public interface IUserService {

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);

}
