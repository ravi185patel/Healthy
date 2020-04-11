package com.example.model;

import com.example.customeannotation.UniqueUsername;
import com.example.entity.Account;
import com.example.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Component
public class UsersModel {

    private Long id;

    @NotNull(message = "please provide Username")
    @Size(min=5,max=10,message = "Username length should be between 5 to 10")
    @UniqueUsername(message = "username already used")
    private String userName;

    @NotNull(message = "please provide Password")
    @Size(min=5,max=10,message = "Password length should be between 5 to 10")
    private String password;

    @NotNull(message = "please provide Account is active or not ( o for inactive and 1 for active)")
    private int isActive;

    @Valid
    private Set<RoleModel> roles;

    private AccountModel account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
