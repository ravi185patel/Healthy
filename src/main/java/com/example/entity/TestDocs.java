package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TestDocs implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long testId;

    private String testDocName;

    @ManyToOne
    @JoinColumn(name = "testId",insertable = false,updatable = false)
    private Test test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTestDocName() {
        return testDocName;
    }

    public void setTestDocName(String testDocName) {
        this.testDocName = testDocName;
    }
}
