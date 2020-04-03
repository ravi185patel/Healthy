package com.example.customeannotation;

import com.example.model.AddressModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListValidatorI implements ConstraintValidator<ListValidator, List<AddressModel>> {

    @Override
    public void initialize(ListValidator paramA) {
    }

    @Override
    public boolean isValid(List<AddressModel> objectLst, ConstraintValidatorContext ctx) {
         if(objectLst ==null) return false;
         else if(objectLst.size()==0) return false;
         else{
             System.out.println(objectLst.get(0) instanceof AddressModel);
             return true;
         }
    }
}

