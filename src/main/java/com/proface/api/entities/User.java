package com.proface.api.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "has_email_alert")
    private boolean hasEmailAlert;

    @Column(name = "has_app_alert")
    private boolean hasAppAlert;

    @ManyToMany( fetch = FetchType.EAGER,
        cascade = {
            CascadeType.MERGE
    })
    @JoinTable(name="app_user_role",
        joinColumns = { @JoinColumn(name="user_id")},
            inverseJoinColumns = { @JoinColumn(name="role_id")}
    )
    private List<Role> roles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHasEmailAlert() {
        return hasEmailAlert;
    }

    public void setHasEmailAlert(boolean hasEmailAlert) {
        this.hasEmailAlert = hasEmailAlert;
    }

    public boolean isHasAppAlert() {
        return hasAppAlert;
    }

    public void setHasAppAlert(boolean hasAppAlert) {
        this.hasAppAlert = hasAppAlert;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, password, username);
    }
}