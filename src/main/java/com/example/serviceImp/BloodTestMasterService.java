package com.example.serviceImp;

import com.example.entity.BloodTestMaster;
import com.example.mapper.MapperInterface;
import com.example.model.BloodTestMasterModel;
import com.example.repository.Dao;
import com.example.service.BloodTestMasterSerivceI;
import com.example.userdefineexception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodTestMasterService implements BloodTestMasterSerivceI<BloodTestMasterModel> {

    @Autowired
    private Dao<BloodTestMaster> bloodTestMasterDao;

    @Autowired
    @Qualifier("testMasterMapper")
    private MapperInterface<BloodTestMasterModel, BloodTestMaster> bloodTestMasterMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public BloodTestMasterModel add(BloodTestMasterModel bloodTestMasterModel) {
        return bloodTestMasterMapper.entityToModel(bloodTestMasterDao.save(bloodTestMasterMapper.modelToEntity(bloodTestMasterModel)));
    }

    @Override
    public BloodTestMasterModel get(Long id) {
        Optional<BloodTestMaster> optionalBloodTestMaster=bloodTestMasterDao.find(id);
        if(!optionalBloodTestMaster.isPresent()){
            throw new RecordNotFoundException(" BloodTestMaster not found for specific SSN");
        }
        return bloodTestMasterMapper.entityToModel(optionalBloodTestMaster.get());
    }

    @Override
    public List<BloodTestMasterModel> getAll() {
        return bloodTestMasterMapper.entityLstToModelLst(bloodTestMasterDao.getAll());
    }

    @Override
    public BloodTestMasterModel update(BloodTestMasterModel bloodTestMasterModel) {
        return null;
    }

}
