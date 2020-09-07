package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.entity.Users;
import com.example.model.PatientModel;
import com.example.model.UsersModel;
import com.example.service.ServiceI;
import com.example.service.UsersServiceI;
import com.example.serviceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.inject.Provider;
import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private UsersServiceI<UsersModel> userSerivce;

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

    @GetMapping("/api/login")
    public ResponseEntity<Object> successfullLogin(@AuthenticationPrincipal final UserDetails userDetails){
        UsersModel user=userSerivce.get(userDetails.getUsername());
        user.setPassword(null);
        return commonResponseProvider.get().getSuccessFullResponse(user,true);
    }

    @PostMapping("/api/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UsersModel userModel){
        return commonResponseProvider.get().getSuccessFullResponse(userSerivce.add(userModel),true);
    }
}
