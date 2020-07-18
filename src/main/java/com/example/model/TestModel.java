package com.example.model;

import com.example.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Component
public class TestModel implements Serializable {
    private Long id;

    private Long doctorId;

    private Long patientId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BloodTestMasterModel> bloodTestMaster;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AccountModel account;

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

    public List<BloodTestMasterModel> getBloodTestMaster() {
        return bloodTestMaster;
    }

    public void setBloodTestMaster(List<BloodTestMasterModel> bloodTestMaster) {
        this.bloodTestMaster = bloodTestMaster;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
