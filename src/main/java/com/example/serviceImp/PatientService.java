package com.example.serviceImp;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.mapper.MapperInterface;
import com.example.model.PatientModel;
import com.example.repository.Dao;
import com.example.repository.PatientDaoI;
import com.example.service.PatientServiceI;
import com.example.userdefineexception.RecordNotFoundException;
import com.example.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientServiceI<PatientModel> {

    @Autowired
    private PatientDaoI<Patient> patientDao;

    @Autowired
    private MapperInterface<PatientModel, Patient> patientMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PatientModel getByUserId(Long id) {
        Optional<Patient> optionalPatient=patientDao.findByUserId(id);
        if(!optionalPatient.isPresent()){
            throw new RecordNotFoundException("Patient not found");
        }
        return patientMapper.entityToModel(optionalPatient.get());
    }

    @Transactional(rollbackOn = Exception.class,value = Transactional.TxType.REQUIRED)
    @Override
    public PatientModel add(PatientModel patientModel) {
//        return patientMapper.entityToModel(patientDao.save(patientMapper.modelToEntity(patientModel)));
        Patient patient=patientDao.save(patientMapper.modelToEntity(patientModel));
        if(patient!=null){
            Utility.createDir("./upload/"+patient.getId());
        }
        return patientMapper.entityToModel(patient);
    }

    @Override
    public PatientModel get(Long id) {
        Optional<Patient> optionalPatient=patientDao.find(id);
        if(!optionalPatient.isPresent()){
            throw new RecordNotFoundException("Patient not found");
        }
        return patientMapper.entityToModel(optionalPatient.get());
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
