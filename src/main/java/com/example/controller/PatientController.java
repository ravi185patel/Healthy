package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.entity.Patient;
import com.example.model.PatientModel;
import com.example.service.PatientServiceI;
import com.example.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Provider;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientServiceI<PatientModel> patientService;

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfile(@PathVariable("id") Long id){
        return commonResponseProvider.get().getSuccessFullResponse(patientService.get(id),true);
    }
    @GetMapping("/profile/{userId}")
    public ResponseEntity<Object> getProfileByUserId(@PathVariable("userId") Long userId){
        return commonResponseProvider.get().getSuccessFullResponse(patientService.getByUserId(userId),true);
    }

    @PostMapping
    public ResponseEntity<Object> createProfile(@Valid @RequestBody PatientModel patientModel){
        return commonResponseProvider.get().getSuccessFullResponse(patientService.add(patientModel),true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProfile(@Valid @RequestBody PatientModel patientModel, @PathVariable("id") Long id){
        PatientModel patientModelObj = patientService.get(id);
        patientModel.setId(id);
        return commonResponseProvider.get().getSuccessFullResponse(patientService.add(patientModel),true);
    }

    @DeleteMapping("/{id}")
    public PatientModel inactiveProfile(@PathVariable("id") Long id){
        // just set isActive column -> false for inactive
        return null;
    }

}
