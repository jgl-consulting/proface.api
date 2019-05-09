package com.proface.api.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
