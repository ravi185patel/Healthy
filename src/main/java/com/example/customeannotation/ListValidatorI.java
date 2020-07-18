package com.example.customeannotation;

import com.example.model.AddressModel;
import com.example.model.DoctorAddressModel;
import com.example.model.PatientAddressModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
//<? extends AddressModel>
public class ListValidatorI implements ConstraintValidator<ListValidator, List> {

    @Override
    public void initialize(ListValidator paramA) {
    }

    @Override
    public boolean isValid(List objectLst, ConstraintValidatorContext ctx) {
         if(objectLst ==null) return false;
         else if(objectLst.size()==0) return false;
         else{
             if(objectLst.get(0) instanceof PatientAddressModel){
                return true;
             }else if(objectLst.get(0) instanceof DoctorAddressModel){
                 return true;
             }
             return false;
         }
    }
}

