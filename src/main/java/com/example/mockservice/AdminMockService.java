package com.example.mockservice;

import com.example.commonresponse.SuccessFullResponse;
import com.example.dao.PatientDao;
import com.example.entity.*;
import com.example.model.AddressModel;
import com.example.model.DoctorModel;
import com.example.model.PatientModel;
import com.example.repository.AccountRepository;
import com.example.repository.Dao;
import com.example.repository.UsersRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Component
public class AdminMockService {

    @Autowired
    private Dao<Patient> patientDao;

    @Autowired
    private Dao<Doctor> doctorDao;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AccountRepository accountRepository;


    public Patient addPatient(Patient patient){
        return patientDao.save(patient);
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorDao.save(doctor);
    }

    public Users addUser(Users user){
        return usersRepository.save(user);
    }
    public Patient getPatient(Long id){
        return patientDao.find(id);
    }

    public Users getUser(Long id){
        Optional<Users> op=usersRepository.findById(id);
        System.out.println(op.isPresent()+" is present or not ");
        return op.get();
    }
    public Account getAccount(Long id){
        Optional<Account> op=accountRepository.findById(id);
        System.out.println(op.isPresent()+" is present or not ");
        return op.get();
    }
    public static void print(Object data){
//        SuccessFullResponse successFullResponse=(SuccessFullResponse) data;
//        Object dataObj=successFullResponse.getData();
//        if(dataObj instanceof List){
//            List lst=(List)dataObj;
//            for(Object obj:lst){
//                if(obj instanceof PatientModel){
//                    PatientModel patientModel=(PatientModel) obj;
//                    System.out.println(patientModel.getFirstName());
//                }else{
//                    System.out.println(obj);
//                }
//            }
//        }
//        else{
//            if(dataObj instanceof  PatientModel){
//                PatientModel patientModel=(PatientModel) dataObj;
//                System.out.println(patientModel.getFirstName());
//            }
//        }
    }
    public static List<PatientModel> getAllPatient(){
        List<PatientModel> patientModelList=new ArrayList<>();
//        for(int i=0;i<10;i++){
//            PatientModel patientModel=new PatientModel();
//            patientModel.setId(Long.valueOf(i));
//            patientModel.setFirstName("ravi "+i);
//            patientModel.setLastName("patel "+i);
//            patientModel.setCellPhone("8153 "+i);
//            patientModel.setEmailId("aryanrdp "+i);
//            List<AddressModel> addressModelList=new ArrayList<>();
//            for(int j=0;j<4;j++){
//                AddressModel addressModel=new AddressModel();
//                addressModel.setAddressId(Long.valueOf(j));
//                addressModel.setAddressLine1("house "+j+","+i);
//                addressModel.setAddressLine2("sai park "+j+","+i);
//                addressModel.setStreet("tulsivan "+j+","+i);
//                addressModel.setCity("valsad "+j+","+i);
//                addressModel.setState("valsad "+j+","+i);
//                addressModel.setCountry("india "+j+","+i);
//                addressModelList.add(addressModel);
//            }
//            patientModel.setAddressList(addressModelList);
//            patientModelList.add(patientModel);
//        }
        return patientModelList;
    }

    public static void printEntity(Object data){
        if(data instanceof Patient){
            System.out.println(" geeting data in object");
            Patient patient=(Patient)data;
//            System.out.println(patient.getPerson().getFirstName()+" "+patient.getPerson().getAddressList().get(0).getAddressLine1());
//            System.out.println(patient.getPerson().getUser()==null  ? "is null":"not null "+patient.getPerson().getUser().getUserName());
            System.out.println();
        }else if(data instanceof  List){
            System.out.println(" geeting data in list formate");
            List lst=(List)data;
            for(Object obj:lst){
                if(obj instanceof Patient){
                    Patient patient=(Patient) obj;
//                    System.out.println(patient.getPerson().getFirstName()+" "+patient.getPerson().getAddressList().get(0).getAddressLine1());
                }else{
                    System.out.println(obj);
                }
            }
        }else if(data instanceof Doctor){

        }
    }
    public List<DoctorModel> getAllDocs(){
       return null;
    }

    public List<AddressModel> getAllAddress(Long id){
        return null;
    }

    public void addData(){
        Patient p=new Patient();
        Person person=new Person();
//        person.setFirstName("ravi");
//        person.setLastName("patel");
        Address address=new Address();
        address.setCity("valsad");
        List<Address> addlst=new ArrayList<>();
        addlst.add(address);
//        person.setAddressList(addlst);
//        p.setPerson(person);
        patientDao.save(p);

    }
}
