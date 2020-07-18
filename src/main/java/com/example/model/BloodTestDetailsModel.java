package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BloodTestDetails implements Serializable {

    @Id
    private Long id;

    private String normal;

}
