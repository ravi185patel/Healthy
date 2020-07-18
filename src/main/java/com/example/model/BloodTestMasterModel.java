package com.example.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
public class BloodTestMasterModel implements Serializable {

    private Long id;
    private List<BloodTestDetailsModel> testDetailsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BloodTestDetailsModel> getTestDetailsList() {
        return testDetailsList;
    }

    public void setTestDetailsList(List<BloodTestDetailsModel> testDetailsList) {
        this.testDetailsList = testDetailsList;
    }
}
