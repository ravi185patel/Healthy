package com.example.serviceImp;

import com.example.entity.Patient;
import com.example.mapper.MapperInterface;
import com.example.model.PatientModel;
import com.example.repository.Dao;
import com.example.service.PatientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientServiceI<PatientModel,PatientModel> {

    @Autowired
    private Dao<Patient> patientDao;

    @Autowired
    private MapperInterface<PatientModel, Patient> patientMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PatientModel add(PatientModel patientModel) {
//        Patient patient=patientMapper.modelToEntity(patientModel);
////        patient.getPerson().setId(null);
//        patient=patientDao.save(patient);
//        System.out.println("call function");
//        PatientModel res=patientMapper.entityToModel(patient);
        return patientMapper.entityToModel(patientDao.save(patientMapper.modelToEntity(patientModel)));
    }

    @Override
    public PatientModel get(Long id) {
        return patientMapper.entityToModel(patientDao.find(id));
    }

    @Override
    public List<PatientModel> getAll() {
        return patientMapper.entityLstToModelLst(patientDao.getAll());
    }

    @Override
    public PatientModel update(PatientModel patientModel) {
        return null;
    }

}
