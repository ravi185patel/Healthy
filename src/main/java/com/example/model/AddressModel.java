package com.example.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Component
public class AddressModel implements Serializable {

    @Size(min=5,max = 10,message = "Address length should be between 5 to 10")
    @NotNull(message = "Please provide address")
    private String addressLine1;

    @Size(min=5,max = 10,message = "Address length should be between 5 to 10")
    @NotNull(message = "Please provide address")
    private String addressLine2;

    @Size(min=5,max = 10,message = "Street length should be between 5 to 10")
    @NotNull(message = "Please provide Street")
    private String street;

    @Size(min=5,max = 10,message = "city length should be between 5 to 10")
    @NotNull(message = "Please provide city")
    private String city;

    @Size(min=5,max = 10,message = "State length should be between 5 to 10")
    @NotNull(message = "Please provide state")
    private String state;

    @Size(min=5,max = 10,message = "Country length should be between 5 to 10")
    @NotNull(message = "Please provide country")
    private String country;

    @Size(min=5,max = 5,message = "Pincode length should be between 5 to 10")
    @NotNull(message = "Please provide pincode")
    private String pinCode;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
