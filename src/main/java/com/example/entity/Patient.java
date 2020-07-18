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
import java.util.Set;

@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(length=10)
    @NotNull(message = "Please provide first name")
    @Size(min=2, max=10, message="Your name should be between 5 - 10 characters.")
    private String firstName;

    @Column(length=10)
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
    private String emailId;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<PatientAddress> addressList;

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

    public List<PatientAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<PatientAddress> addressList) {
        this.addressList = addressList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
