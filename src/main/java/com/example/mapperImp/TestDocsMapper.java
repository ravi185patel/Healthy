package com.example.mapperImp;

import com.example.entity.TestDocs;
import com.example.mapper.MapperInterface;
import com.example.model.TestDocsModel;
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
public class TestDocsMapper implements MapperInterface<TestDocsModel, TestDocs> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TestDocs modelToEntity(TestDocsModel TestDocsModel) {
//        TestDocs TestDocs;//=new TestDocs();
//        TestDocs=modelMapper.map(TestDocsModel,TestDocs.class);
//        System.out.println(TestDocs.getPerson().getFirstName()+" < get first name");
//        BeanUtils.copyProperties(TestDocsModel, TestDocs);
//        Person=
//        System.out.println(TestDocs.getPerson().getFirstName());
        TestDocs testDocs=modelMapper.map(TestDocsModel,TestDocs.class);
        if(testDocs.getId()==null){
            testDocs.setId(TestDocsModel.getTestDocsId());
        }
        return testDocs;
    }

    @Override
    public TestDocsModel entityToModel(TestDocs TestDocs) {
//        TestDocsModel TestDocsModel;//=new TestDocsModel();
////        BeanUtils.copyProperties(TestDocsModel, TestDocs);
//        TestDocsModel=modelMapper.map(TestDocs,TestDocsModel.class);
////        System.out.println(TestDocsModel.getAddressList().get(0).getAddressId());
        return modelMapper.map(TestDocs,TestDocsModel.class);
    }

    @Override
    public Collection<TestDocs> modelLstToEntityLst(Collection<TestDocsModel> t) {
        List<TestDocs> TestDocsList=new ArrayList<TestDocs>();
        t.stream().forEach(TestDocsModel -> {
            TestDocsList.add(modelToEntity(TestDocsModel));
        });
        return TestDocsList;
    }

    @Override
    public List<TestDocsModel> entityLstToModelLst(Collection<TestDocs> r) {

        Type listType = new TypeToken<Collection<TestDocsModel>>(){}.getType();
        List<TestDocsModel> TestDocsModelList = modelMapper.map(r,listType);
//
//        List<TestDocsModel> TestDocsModelList=new ArrayList<TestDocsModel>();
//        r.stream().forEach(TestDocs -> {
//            TestDocsModel TestDocsModel=entityToModel(TestDocs);
//            TestDocsModelList.add(TestDocsModel);
//        });
        return TestDocsModelList;
    }

    @Override
    public Page<TestDocsModel> entityToModel(Page<TestDocs> r) {
        return null;
    }
}
