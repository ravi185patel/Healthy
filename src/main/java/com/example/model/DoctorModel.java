package com.example.model;

import com.example.customeannotation.ListValidator;
import com.example.customeannotation.Phone;
import com.example.customeannotation.UniqueEmail;
import com.example.entity.Account;
import com.example.entity.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class DoctorModel implements Serializable {

    private Long id;

    @NotNull(message = "please provide specialisation")
    @Size(min=5,max=10,message = "specialisation's length should be between 5 to 10")
    private String specialisation;

    @NotNull(message = "please provide docId")
    @Size(min=5,max=10,message = "Doctor id's length should be between 5 to 10")
    private String docId;

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
//    @UniqueEmail
    private String emailId;

    @ListValidator
    private List<DoctorAddressModel> addressList;

    private Long userId;

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

    public List<DoctorAddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<DoctorAddressModel> addressList) {
        this.addressList = addressList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
