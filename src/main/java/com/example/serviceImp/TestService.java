package com.example.serviceImp;

import com.example.entity.Patient;
import com.example.entity.Test;
import com.example.mapper.MapperInterface;
import com.example.model.TestModel;
import com.example.repository.Dao;
import com.example.repository.TestDaoI;
import com.example.service.TestSerivceI;
import com.example.specification.TestListRequest;
import com.example.userdefineexception.RecordNotFoundException;
import com.example.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements TestSerivceI<TestModel> {

    @Autowired
    private TestDaoI<Test> testDao;

    @Autowired
    private MapperInterface<TestModel, Test> testMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<TestModel> findAll(TestListRequest request,Pageable pageable) {
        return testMapper.entityToModel(testDao.findAll(request,pageable));
    }

    @Override
    public TestModel add(TestModel testModel) {
//        return testMapper.entityToModel();
        Test test=testDao.save(testMapper.modelToEntity(testModel));
        if(test!=null){
            System.out.println(" folder generated");
            Utility.createDir("./uploads/19/"+test.getId());
        }
        return testMapper.entityToModel(test);
    }

    @Override
    public TestModel get(Long id) {
        Optional<Test> optionalTest=testDao.find(id);
        if(!optionalTest.isPresent()){
            throw new RecordNotFoundException(" Test not found for specific SSN");
        }
        return testMapper.entityToModel(optionalTest.get());
    }

    @Override
    public List<TestModel> getAll() {
        return testMapper.entityLstToModelLst(testDao.getAll());
    }

    @Override
    public TestModel update(TestModel testModel) {
        return null;
    }

}
