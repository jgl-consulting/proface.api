package com.proface.api.services;

import com.proface.api.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);
	
	User findOne(Long id);

	List<User> findAll(String search);

}
