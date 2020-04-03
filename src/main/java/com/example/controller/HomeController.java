package com.example.controller;

import com.example.entity.Person;
import com.example.model.PatientModel;
import com.example.model.PersonModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HomeController {

    @GetMapping("/p")
    public String getHome(){ return "home there" ;}


    @PostMapping("/patients")
    public ResponseEntity<Object> addPatients(@Valid @RequestBody PatientModel person){
        return ResponseEntity.ok("valid");
//        return commonResponse.getSuccessFullResponse(patientService.add(patientModel),true);
    }

}
