package com.proface.api.repositories;

import com.proface.api.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

import java.util.Optional;

@Secured("ADMIN")
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

	Page<User> findAllByUsernameContains(Pageable pageable, @Param("username") String username);

	boolean existsByUsername(String username);

	Optional<User> findUserByUsername(String username);

}
