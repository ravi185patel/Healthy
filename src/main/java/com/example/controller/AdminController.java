package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.model.PatientModel;
import com.example.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ServiceI<PatientModel, PatientModel> patientService;

    @Autowired
    private CommonResponse commonResponse;

    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
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
