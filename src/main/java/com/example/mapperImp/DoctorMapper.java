package com.example.mapperImp;

import com.example.entity.Doctor;
import com.example.mapper.MapperInterface;
import com.example.model.DoctorModel;
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
public class DoctorMapper implements MapperInterface<DoctorModel, Doctor> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Doctor modelToEntity(DoctorModel DoctorModel) {
//        Doctor Doctor;//=new Doctor();
//        Doctor=modelMapper.map(DoctorModel,Doctor.class);
//        System.out.println(Doctor.getPerson().getFirstName()+" < get first name");
//        BeanUtils.copyProperties(DoctorModel, Doctor);
//        Person=
//        System.out.println(Doctor.getPerson().getFirstName());
        return modelMapper.map(DoctorModel,Doctor.class);
    }

    @Override
    public DoctorModel entityToModel(Doctor Doctor) {
//        DoctorModel DoctorModel;//=new DoctorModel();
////        BeanUtils.copyProperties(DoctorModel, Doctor);
//        DoctorModel=modelMapper.map(Doctor,DoctorModel.class);
////        System.out.println(DoctorModel.getAddressList().get(0).getAddressId());
        return modelMapper.map(Doctor,DoctorModel.class);
    }

    @Override
    public Collection<Doctor> modelLstToEntityLst(Collection<DoctorModel> t) {
        List<Doctor> DoctorList=new ArrayList<Doctor>();
        t.stream().forEach(DoctorModel -> {
            DoctorList.add(modelToEntity(DoctorModel));
        });
        return DoctorList;
    }

    @Override
    public List<DoctorModel> entityLstToModelLst(Collection<Doctor> r) {

        Type listType = new TypeToken<Collection<DoctorModel>>(){}.getType();
        List<DoctorModel> DoctorModelList = modelMapper.map(r,listType);
//
//        List<DoctorModel> DoctorModelList=new ArrayList<DoctorModel>();
//        r.stream().forEach(Doctor -> {
//            DoctorModel DoctorModel=entityToModel(Doctor);
//            DoctorModelList.add(DoctorModel);
//        });
        return DoctorModelList;
    }

    @Override
    public Page<DoctorModel> entityToModel(Page<Doctor> r) {
        return null;
    }
}
