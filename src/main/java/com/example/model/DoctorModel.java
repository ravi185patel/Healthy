package com.example.model;

import com.example.entity.Account;
import com.example.entity.Person;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class DoctorModel extends PersonModel{

    private Long id;

    @NotNull(message = "please provide specialisation")
    @Size(min=5,max=10,message = "specialisation's length should be between 5 to 10")
    private String specialisation;

    @NotNull(message = "please provide docId")
    @Size(min=5,max=10,message = "Doctor id's length should be between 5 to 10")
    private String docId;

    @Valid
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
