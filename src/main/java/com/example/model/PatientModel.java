package com.example.model;

import com.example.customeannotation.ListValidator;
import com.example.customeannotation.Phone;
import com.example.customeannotation.UniqueEmail;
import com.example.entity.Account;
import com.example.entity.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
@JsonRootName("patient")
public class PatientModel implements Serializable {

    private Long id;

    @NotNull
    @NotNull(message = "Please provide first name")
    @Size(min=2, max=10, message="Your name should be between 5 - 10 characters.")
    private String firstName;

    @NotNull
    @NotNull(message = "Please provide last name")
    @Size(min=2, max=10, message="Your name should be between 5 - 10 characters.")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @NotNull(message = "please provide birthdate")
    @Past
    private Date birthDate;

    @Phone(message = "please provide valid contact number")
    @NotNull(message = "please provide contact number")
    private String cellPhone;

    @Email(message = "please provide valid email id")
    @NotNull(message = "please provide emailid")
//    @UniqueEmail
    private String emailId;

    @ListValidator
    private List<PatientAddressModel> address;

    @NotNull(message = "please provide userId")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PatientAddressModel> getAddress() {
        return address;
    }

    public void setAddress(List<PatientAddressModel> address) {
        this.address = address;
    }
}
