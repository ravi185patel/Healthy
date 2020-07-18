package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BloodTestMaster implements Serializable {

    @Id
    private Long id;

    @OneToOne
    private Test test;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "btm_id")
    private List<BloodTestDetails> testDetailsList;
    
}
