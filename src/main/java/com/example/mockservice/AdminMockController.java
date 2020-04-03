package com.example.mockservice;

import com.example.commonresponse.CommonResponse;
import com.example.commonresponse.SuccessFullResponse;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Users;
import com.example.mapperImp.PatientMapper;
import com.example.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/adminmock")
public class AdminMockController {

    @Autowired
    private CommonResponse commonResponse;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private AdminMockService adminMockService;

    @GetMapping("/patients")
    public ResponseEntity<Object> getAllPatient(){
        return commonResponse.getSuccessFullResponse(AdminMockService.getAllPatient(),true);
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id){
//        AdminMockService.printEntity(patient);
        return adminMockService.getPatient(id);
//        AdminMockService.print(successFullResponse);
//        adminMockService.addData();
    }
    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable Long id){
//        AdminMockService.printEntity(patient);
        return adminMockService.getUser(id);
//        AdminMockService.print(successFullResponse);
//        adminMockService.addData();
    }

    @PostMapping("/patients")
    public Patient addPatients(@RequestBody Patient patient){
        AdminMockService.printEntity(patient);
        return adminMockService.addPatient(patient);
//        AdminMockService.print(successFullResponse);
//        adminMockService.addData();
    }

    @PostMapping("/doctors")
    public Doctor addPatients(@RequestBody Doctor doctor){
//        AdminMockService.printEntity(patient);
        return adminMockService.addDoctor(doctor);
//        AdminMockService.print(successFullResponse);
//        adminMockService.addData();
    }

    @PostMapping("/employees")
    public Users addEmployee(@RequestBody Users user){
//        AdminMockService.printEntity(patient);
        return adminMockService.addUser(user);
//        AdminMockService.print(successFullResponse);
//        adminMockService.addData();
    }

    @PostMapping("/patientLst")
    public void addPatientLst(@RequestBody SuccessFullResponse<List<PatientModel>> successFullResponse){
//        successFullResponse.getData().stream().forEach(patient -> System.out.println(patient.getFirstName()));
        AdminMockService.printEntity(patientMapper.modelLstToEntityLst(successFullResponse.getData()));
        AdminMockService.print(successFullResponse);
    }
}

