package com.example.serviceImp;

import com.example.entity.Doctor;
import com.example.mapper.MapperInterface;
import com.example.model.DoctorModel;
import com.example.repository.Dao;
import com.example.service.DoctorSerivceI;
import com.example.userdefineexception.RecordNotFoundException;
import com.example.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements DoctorSerivceI<DoctorModel> {

    @Autowired
    private Dao<Doctor> DoctorDao;

    @Autowired
    private MapperInterface<DoctorModel, Doctor> DoctorMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public DoctorModel add(DoctorModel DoctorModel) {
        Doctor doctor=DoctorDao.save(DoctorMapper.modelToEntity(DoctorModel));
        if(doctor!=null){
            Utility.createDir(doctor.getFirstName()+doctor.getDocId());
        }
        return DoctorMapper.entityToModel(doctor);
    }

    @Override
    public DoctorModel get(Long id) {
        Optional<Doctor> optionalDoctor=DoctorDao.find(id);
        if(!optionalDoctor.isPresent()){
            throw new RecordNotFoundException(" Doctor not found for specific SSN");
        }
        return DoctorMapper.entityToModel(optionalDoctor.get());
    }

    @Override
    public List<DoctorModel> getAll() {
        return DoctorMapper.entityLstToModelLst(DoctorDao.getAll());
    }

    @Override
    public DoctorModel update(DoctorModel DoctorModel) {
        return null;
    }

}
