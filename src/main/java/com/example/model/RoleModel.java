package com.example.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component
public class RoleModel implements Serializable {

    private Long id;

    @NotNull(message = "Please provide role name (ADMIN,USER,OTHERS)")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName.toUpperCase();
    }
}
