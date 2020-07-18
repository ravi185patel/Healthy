package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BloodTestDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String label;
    private Double normal;
    private Double abnormal;
    private String flag;
    private String units;
    private Double referenceStartRange;
    private Double referenceEndRange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getNormal() {
        return normal;
    }

    public void setNormal(Double normal) {
        this.normal = normal;
    }

    public Double getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(Double abnormal) {
        this.abnormal = abnormal;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Double getReferenceStartRange() {
        return referenceStartRange;
    }

    public void setReferenceStartRange(Double referenceStartRange) {
        this.referenceStartRange = referenceStartRange;
    }

    public Double getReferenceEndRange() {
        return referenceEndRange;
    }

    public void setReferenceEndRange(Double referenceEndRange) {
        this.referenceEndRange = referenceEndRange;
    }
}
