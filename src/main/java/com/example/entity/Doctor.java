package com.example.entity;


import com.example.customeannotation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Doctor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "please provide specialisation")
    @Size(min=5,max=10,message = "specialisation's length should be between 5 to 10")
    @Column(length=10)
    private String specialisation;

    @NotNull(message = "please provide docId")
    @Column(length=10)
    @Size(min=5,max=10,message = "Doctor id's length should be between 5 to 10")
    private String docId;


    @Column(length=10)
    @NotNull(message = "Please provide first name")
    @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
    private String firstName;

    @Column(length=10)
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
    private String emailId;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private List<DoctorAddress> addressList;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "userId",insertable=false, updatable = false)
    private Users users;

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

    public List<DoctorAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<DoctorAddress> addressList) {
        this.addressList = addressList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
