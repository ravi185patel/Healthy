package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long doctorId;
    private String parentTestName;
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "doctorId",insertable = false,updatable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientId",insertable = false,updatable = false)
    private Patient patient;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<BloodTestMaster> bloodTestMaster;

//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name = "test_id")
//    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public List<BloodTestMaster> getBloodTestMaster() {
        return bloodTestMaster;
    }

    public void setBloodTestMaster(List<BloodTestMaster> bloodTestMaster) {
        this.bloodTestMaster = bloodTestMaster;
    }

    //    public BloodTestMaster getBloodTestMaster() {
//        return bloodTestMaster;
//    }
//
//    public void setBloodTestMaster(BloodTestMaster bloodTestMaster) {
//        this.bloodTestMaster = bloodTestMaster;
//    }


    public String getParentTestName() {
        return parentTestName;
    }

    public void setParentTestName(String parentTestName) {
        this.parentTestName = parentTestName;
    }
}
