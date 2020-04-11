package com.example.customeannotation;

import com.example.entity.Users;
import com.example.serviceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserDetailsServiceImpl userService;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !userService.isUsernameAlreadyInUse(value);
    }

}