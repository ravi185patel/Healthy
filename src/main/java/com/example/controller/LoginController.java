package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @GetMapping("/api/login")
    public UserDetails successfullLogin(@AuthenticationPrincipal final UserDetails userDetails){
        return userDetails;
    }
}
