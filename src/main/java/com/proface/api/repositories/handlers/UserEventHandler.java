package com.proface.api.repositories.handlers;

import com.proface.api.entities.User;
import com.proface.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserBeforeSave(User user) {
        if (user.getPassword().trim().isEmpty()) {
            User storedUser = userRepository
                    .findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("User not exists"));

            user.setPassword(storedUser.getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }
}