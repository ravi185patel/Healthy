package com.example.serviceImp;

import com.example.entity.TestDocs;
import com.example.mapper.MapperInterface;
import com.example.model.TestDocsModel;
import com.example.repository.Dao;
import com.example.service.TestDocsServiceI;
import com.example.userdefineexception.RecordNotFoundException;
import com.example.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TestDocsService implements TestDocsServiceI<TestDocsModel> {

    @Autowired
    private Dao<TestDocs> TestDocsDao;

    @Autowired
    private MapperInterface<TestDocsModel, TestDocs> TestDocsMapper;

    @Override
    public void deleteById(Long id) {

    }

    @Transactional(rollbackOn = Exception.class,value = Transactional.TxType.REQUIRED)
    @Override
    public TestDocsModel add(TestDocsModel TestDocsModel) {
//        return TestDocsMapper.entityToModel(TestDocsDao.save(TestDocsMapper.modelToEntity(TestDocsModel)));
        TestDocs TestDocs=TestDocsDao.save(TestDocsMapper.modelToEntity(TestDocsModel));
        return TestDocsMapper.entityToModel(TestDocs);
    }

    @Override
    public TestDocsModel get(Long id) {
        Optional<TestDocs> optionalTestDocs=TestDocsDao.find(id);
        if(!optionalTestDocs.isPresent()){
            throw new RecordNotFoundException("TestDocs not found");
        }
        return TestDocsMapper.entityToModel(optionalTestDocs.get());
    }

    @Override
    public List<TestDocsModel> getAll() {
        return TestDocsMapper.entityLstToModelLst(TestDocsDao.getAll());
    }

    @Override
    public TestDocsModel update(TestDocsModel TestDocsModel) {
        TestDocs TestDocs=TestDocsDao.update(TestDocsMapper.modelToEntity(TestDocsModel));
        return TestDocsMapper.entityToModel(TestDocs);
    }

}
