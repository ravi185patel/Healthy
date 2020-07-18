package com.example.entity;

import com.example.customeannotation.UniqueEmail;
import com.example.customeannotation.UniqueUsername;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="user")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

//    @NotNull(message = "please provide Username")
//    @Size(min=5,max=10,message = "Username length should be between 5 to 10")
//    @UniqueUsername(message = "username already used")
    private String userName;

//    @NotNull(message = "please provide Password")
//    @Size(min=5,max=10,message = "Password length should be between 5 to 10")
    private String password;

//    @NotNull(message = "please provide Account is active or not ( o for inactive and 1 for active)")
    @Column(name = "active")
    private int isActive;

//    @Email(message = "please provide valid email id")
//    @NotNull(message = "please provide emailid")
//    @UniqueEmail
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @Valid
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
