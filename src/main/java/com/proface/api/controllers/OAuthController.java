package com.proface.api.controllers;

import com.proface.api.entities.User;
import com.proface.api.mappers.UserMapper;
import com.proface.api.services.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @Autowired
    private UsuarioService usersService;

    private UserMapper userMapper = UserMapper.INSTANCE;

    @GetMapping("/info")
    public ResponseEntity<?> info(Authentication authentication) {

        String username = (String) authentication.getPrincipal();

        Optional<User> user = usersService.findByUsername(username);

        Function<User, ResponseEntity<?>> mapToResponse =
                (u) -> ResponseEntity.of(singletonMap("user", userMapper.convertToModel(u)));

        return user.map(mapToResponse)
                .orElse(ResponseEntity.badRequest().build());
    }

    private Optional<Map<String,?>> singletonMap(String key, Object value) {
        return Optional.of(Collections.singletonMap(key, value));
    }
}