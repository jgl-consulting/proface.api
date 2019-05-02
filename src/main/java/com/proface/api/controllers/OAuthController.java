package com.proface.api.controllers;

import com.proface.api.entities.Usuario;
import com.proface.api.mappers.UsuarioMapper;
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

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @Autowired
    private UsuarioService usersService;

    @GetMapping("/info")
    public ResponseEntity<?> info(Authentication authentication) {

        String username = (String) authentication.getPrincipal();

        Optional<Usuario> user = usersService.findByUsername(username);

        return user.map((u) -> ResponseEntity.of(
                optionalSingletonlMap("user", UsuarioMapper.INSTANCE.convertToModel(u))
        )).orElse(ResponseEntity.badRequest().build());

    }

    private Optional<Map<String,?>> optionalSingletonlMap(String key, Object value) {
        return Optional.of(Collections.singletonMap(key, value));
    }

}