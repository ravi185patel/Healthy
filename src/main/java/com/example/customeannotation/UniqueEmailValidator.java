package com.example.customeannotation;

import com.example.serviceImp.AccountService;
import com.example.serviceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !userDetailsService.isEmailAlreadyInUse(value);
    }

}