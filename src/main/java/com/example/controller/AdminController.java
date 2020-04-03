package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.model.PatientModel;
import com.example.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ServiceI<PatientModel, PatientModel> patientService;

    @Autowired
    private CommonResponse commonResponse;


    @GetMapping
    public String getHome(){
        return "adminHome";
    }

    @GetMapping("/patients")
    public ResponseEntity<Object> getAllPatient(){
        return commonResponse.getSuccessFullResponse(patientService.getAll(),true);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Object> getPatient(@PathVariable Long id){
        return commonResponse.getSuccessFullResponse(patientService.get(id),true);
    }

    @PostMapping("/patients")
    public ResponseEntity<Object> addPatients(@Valid  @RequestBody PatientModel patientModel){
        return commonResponse.getSuccessFullResponse(patientService.add(patientModel),true);
    }

}
