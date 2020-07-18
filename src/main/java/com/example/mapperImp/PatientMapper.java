package com.example.mapperImp;

import com.example.entity.Address;
import com.example.entity.Patient;
import com.example.entity.Person;
import com.example.mapper.MapperInterface;
import com.example.model.PatientModel;
import com.example.model.PersonModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PatientMapper implements MapperInterface<PatientModel, Patient> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Patient modelToEntity(PatientModel patientModel) {
//        Patient patient;//=new Patient();
//        patient=modelMapper.map(patientModel,Patient.class);
//        System.out.println(patient.getPerson().getFirstName()+" < get first name");
//        BeanUtils.copyProperties(patientModel, patient);
//        Person=
//        System.out.println(patient.getPerson().getFirstName());
        return modelMapper.map(patientModel,Patient.class);
    }

    @Override
    public PatientModel entityToModel(Patient patient) {
//        PatientModel patientModel;//=new PatientModel();
////        BeanUtils.copyProperties(patientModel, patient);
//        patientModel=modelMapper.map(patient,PatientModel.class);
////        System.out.println(patientModel.getAddressList().get(0).getAddressId());
        return modelMapper.map(patient,PatientModel.class);
    }

    @Override
    public Collection<Patient> modelLstToEntityLst(Collection<PatientModel> t) {
        List<Patient> patientList=new ArrayList<Patient>();
        t.stream().forEach(patientModel -> {
            patientList.add(modelToEntity(patientModel));
        });
        return patientList;
    }

    @Override
    public List<PatientModel> entityLstToModelLst(Collection<Patient> r) {

        Type listType = new TypeToken<Collection<PatientModel>>(){}.getType();
        List<PatientModel> patientModelList = modelMapper.map(r,listType);
//
//        List<PatientModel> patientModelList=new ArrayList<PatientModel>();
//        r.stream().forEach(patient -> {
//            PatientModel patientModel=entityToModel(patient);
//            patientModelList.add(patientModel);
//        });
        return patientModelList;
    }

    @Override
    public Page<PatientModel> entityToModel(Page<Patient> r) {
        return null;
    }
}
