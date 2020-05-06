package com.example.model;

import com.example.customeannotation.ListValidator;
import com.example.customeannotation.Phone;
import com.example.customeannotation.UniqueEmail;
import com.example.entity.Address;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonRootName(value = "account")
public class AccountModel implements  Serializable{

    @JsonProperty("account_id")
    private Long id;

    @NotNull
    @NotNull(message = "Please provide first name")
    @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
    private String firstName;

    @NotNull
    @NotNull(message = "Please provide last name")
    @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
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
    @UniqueEmail
    private String emailId;

    @ListValidator
    private List<AddressModel> addressList;

    @Valid
    private UsersModel user;

    private Patient patient;

    private Doctor doctor;

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

    public List<AddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressModel> addressList) {
        this.addressList = addressList;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }
}
