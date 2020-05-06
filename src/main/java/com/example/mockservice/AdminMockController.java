package com.example.mockservice;

import com.example.commonresponse.CommonResponse;
import com.example.commonresponse.SuccessFullResponse;
import com.example.entity.Account;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Users;
import com.example.mapperImp.PatientMapper;
import com.example.model.AccountModel;
import com.example.model.DoctorModel;
import com.example.model.PatientModel;
import com.example.model.UsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Provider;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/adminmock")
public class AdminMockController {

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private AdminMockService adminMockService;

    @GetMapping("/patients")
    public ResponseEntity<Object> getAllPatient(){
        return commonResponseProvider.get().getSuccessFullResponse(AdminMockService.getAllPatient(),true);
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

    @GetMapping("/users")
    public List<UsersModel> getUsers(){
        return null;
    }

    @GetMapping("/accounts")
    public  ResponseEntity<Object> getAccounts() throws IOException {
//        ResponseEntity<Object>
        System.out.println(" called admin mock service ");
//        return adminMockService.getAllAccount();
        return commonResponseProvider.get().getSuccessFullResponse(adminMockService.getAllAccount(),true);
    }

//    @GetMapping("/patients")
//    public List<PatientModel> getPatients(){
//        return null;
//    }

    @GetMapping("/Doctors")
    public List<DoctorModel> getDoctors(){
        return null;
    }

}

