package com.example.serviceImp;

import com.example.entity.BloodTestDetails;
import com.example.mapper.MapperInterface;
import com.example.model.BloodTestDetailsModel;
import com.example.repository.Dao;
import com.example.service.BloodTestDetailsSerivceI;
import com.example.userdefineexception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodTestDetailsService implements BloodTestDetailsSerivceI<BloodTestDetailsModel> {

    @Autowired
    private Dao<BloodTestDetails> bloodTestDetailsDao;

    @Autowired
    @Qualifier("testDetailsMapper")
    private MapperInterface<BloodTestDetailsModel, BloodTestDetails> bloodTestDetailsMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public BloodTestDetailsModel add(BloodTestDetailsModel bloodTestDetailsModel) {
        return bloodTestDetailsMapper.entityToModel(bloodTestDetailsDao.save(bloodTestDetailsMapper.modelToEntity(bloodTestDetailsModel)));
    }

    @Override
    public BloodTestDetailsModel get(Long id) {
        Optional<BloodTestDetails> optionalBloodTestDetails=bloodTestDetailsDao.find(id);
        if(!optionalBloodTestDetails.isPresent()){
            throw new RecordNotFoundException(" BloodTestDetails not found for specific SSN");
        }
        return bloodTestDetailsMapper.entityToModel(optionalBloodTestDetails.get());
    }

    @Override
    public List<BloodTestDetailsModel> getAll() {
        return bloodTestDetailsMapper.entityLstToModelLst(bloodTestDetailsDao.getAll());
    }

    @Override
    public BloodTestDetailsModel update(BloodTestDetailsModel bloodTestDetailsModel) {
        return null;
    }

}
