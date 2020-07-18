package com.example.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Component
@JsonRootName("address")
public class PatientAddressModel extends  AddressModel implements Serializable {

    private Long addressId;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
