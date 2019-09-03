package com.proface.api.services.impl;

import com.proface.api.entities.User;
import com.proface.api.repositories.UserRepository;
import com.proface.api.security.ProfaceUser;
import com.proface.api.services.IUserService;
import com.proface.api.util.ProfaceConverter;
import com.proface.api.util.ProfaceSpecificationBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfaceConverter<User> converter;
	
	@Autowired
	private ProfaceSpecificationBuilder<User> builder;

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("The username %s doesn't exist", username)));
		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		UserDetails userDetails = new ProfaceUser(user.getFirstName(), user.getLastName(), user.getUsername(),
				user.getPassword(), authorities);
		return userDetails;
	}

	@Override
	public List<User> findAll(String search) {
		List<User> list = converter.iterableToList(userRepository.findAll(builder.getSpecification(search)));
		list.forEach(e -> e.setRoles(null));
		return list;
	}

	@Override
	public User findOne(Long id) {
		Optional<User> entity = userRepository.findById(id);
		return entity.orElse(null);
	}

}
