package com.proface.api.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Data
public class ProfaceUser extends User {

    private static final long serialVersionUID = -3531439484732724601L;

    private String firstName;
    private String lastName;

    public ProfaceUser(String firstName, String lastName, String username, String password, List<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
