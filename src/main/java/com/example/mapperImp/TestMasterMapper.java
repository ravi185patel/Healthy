package com.example.mapperImp;

import com.example.entity.BloodTestMaster;
import com.example.entity.BloodTestMaster;
import com.example.mapper.MapperInterface;
import com.example.model.BloodTestMasterModel;
import com.example.model.BloodTestMasterModel;
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
public class TestMasterMapper<T,R> implements MapperInterface<T, R> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public R modelToEntity(T t) {
        Type r = new TypeToken<R>(){}.getType();
        return modelMapper.map(t,r);
    }

    @Override
    public T entityToModel(R r) {
        Type t = new TypeToken<T>(){}.getType();
        return modelMapper.map(r,t);
    }

    @Override
    public Collection<R> modelLstToEntityLst(Collection<T> t) {
        List<R> bloodTestDetailsList=new ArrayList<R>();
        t.stream().forEach(td -> {
            bloodTestDetailsList.add(modelToEntity(td));
        });
        return bloodTestDetailsList;
    }

    @Override
    public List<T> entityLstToModelLst(Collection<R> r) {
        Type listType = new TypeToken<Collection<T>>(){}.getType();
        List<T> bloodTestDetailsList = modelMapper.map(r,listType);
        return bloodTestDetailsList;
    }

    @Override
    public Page<T> entityToModel(Page<R> r) {
        return null;
    }
}