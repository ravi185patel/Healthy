package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.model.DoctorModel;
import com.example.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Provider;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private ServiceI<DoctorModel> doctorService;

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfile(@PathVariable("id") Long id){
        System.out.println("passed param -> "+id);
        return commonResponseProvider.get().getSuccessFullResponse(doctorService.get(id),true);
    }

    @PostMapping
    public ResponseEntity<Object> createProfile(@Valid @RequestBody DoctorModel DoctorModel){
        return commonResponseProvider.get().getSuccessFullResponse(doctorService.add(DoctorModel),true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProfile(@Valid @RequestBody DoctorModel DoctorModel, @PathVariable("id") Long id){
        return commonResponseProvider.get().getSuccessFullResponse(doctorService.add(DoctorModel),true);
    }

    @DeleteMapping("/{id}")
    public DoctorModel inactiveProfile(@PathVariable("id") Long id){
        // just set isActive column -> false for inactive
        return null;
    }

}
