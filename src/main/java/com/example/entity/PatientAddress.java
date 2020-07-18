package com.example.entity;

import javax.persistence.*;

@Entity
public class PatientAddress extends Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "addressId")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
