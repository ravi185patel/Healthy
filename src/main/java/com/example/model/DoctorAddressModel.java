package com.example.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@JsonRootName("address")
public class DoctorAddressModel extends  AddressModel implements Serializable {

    private Long addressId;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
