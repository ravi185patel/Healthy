package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BloodTestMaster implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="test_id")
//    private Test test;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "btm_id")
    private List<BloodTestDetails> testDetailsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Test getTest() {
//        return test;
//    }
//
//    public void setTest(Test test) {
//        this.test = test;
//    }

    public List<BloodTestDetails> getTestDetailsList() {
        return testDetailsList;
    }

    public void setTestDetailsList(List<BloodTestDetails> testDetailsList) {
        this.testDetailsList = testDetailsList;
    }
}
