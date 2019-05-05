package com.proface.api.services;

import com.proface.api.entities.User;

import java.util.Optional;

public interface IUsersService {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
