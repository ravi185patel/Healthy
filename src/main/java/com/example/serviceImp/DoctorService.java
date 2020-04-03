package com.example.serviceImp;

import com.example.entity.Doctor;
import com.example.mapper.MapperInterface;
import com.example.model.DoctorModel;
import com.example.repository.Dao;
import com.example.service.DoctorSerivceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorSerivceI<DoctorModel,DoctorModel> {

    @Autowired
    private Dao<Doctor> DoctorDao;

    @Autowired
    private MapperInterface<DoctorModel, Doctor> DoctorMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public DoctorModel add(DoctorModel DoctorModel) {
        return DoctorMapper.entityToModel(DoctorDao.save(DoctorMapper.modelToEntity(DoctorModel)));
    }

    @Override
    public DoctorModel get(Long id) {
        return DoctorMapper.entityToModel(DoctorDao.find(id));
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
