package com.proface.api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "app_user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @ManyToMany(
    	fetch = FetchType.EAGER,
        cascade = { CascadeType.MERGE }
    )
    @JoinTable(name="app_user_role",
        joinColumns = { @JoinColumn(name="user_id") },
        inverseJoinColumns = { @JoinColumn(name="role_id")}
    )
    private List<Role> roles;

}