package com.example.mapperImp;

import com.example.entity.Test;
import com.example.mapper.MapperInterface;
import com.example.model.TestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class TestMapper implements MapperInterface<TestModel, Test> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Test modelToEntity(TestModel testModel) {
        return modelMapper.map(testModel,Test.class);
    }

    @Override
    public TestModel entityToModel(Test test) {
        return modelMapper.map(test,TestModel.class);
    }

    @Override
    public Collection<Test> modelLstToEntityLst(Collection<TestModel> t) {
        List<Test> TestList=new ArrayList<Test>();
        t.stream().forEach(testModel -> {
            TestList.add(modelToEntity(testModel));
        });
        return TestList;
    }

    @Override
    public List<TestModel> entityLstToModelLst(Collection<Test> r) {
        Type listType = new TypeToken<Collection<TestModel>>(){}.getType();
        List<TestModel> testModelList = modelMapper.map(r,listType);
        return testModelList;
    }

    @Override
    public Page<TestModel> entityToModel(Page<Test> r) {
        Type listType = new TypeToken<Page<TestModel>>(){}.getType();
        Page<TestModel> testModelPageLst = modelMapper.map(r,listType);
        return testModelPageLst;
    }
}
