package com.proface.api.repositories.handlers;

import com.proface.api.entities.Usuario;
import com.proface.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
class UsuarioEventHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @HandleBeforeCreate
    public void handleUserCreate(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserUpdate(Usuario usuario) {
        if (usuario.getPassword() == null || usuario.getPassword().equals("")) {

            Usuario storedUser = usuarioRepository
                    .findById(usuario.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not exists"));

            usuario.setPassword(storedUser.getPassword());
        } else {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
    }
}