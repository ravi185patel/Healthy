package com.example.mapperImp;

import com.example.entity.Users;
import com.example.mapper.MapperInterface;
import com.example.model.UsersModel;
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
public class UsersMapper implements MapperInterface<UsersModel, Users> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Users modelToEntity(UsersModel UsersModel) {
        return modelMapper.map(UsersModel,Users.class);
    }

    @Override
    public UsersModel entityToModel(Users Users) {
        return modelMapper.map(Users,UsersModel.class);
    }

    @Override
    public Collection<Users> modelLstToEntityLst(Collection<UsersModel> t) {
        List<Users> UsersList=new ArrayList<Users>();
        t.stream().forEach(UsersModel -> {
            UsersList.add(modelToEntity(UsersModel));
        });
        return UsersList;
    }

    @Override
    public List<UsersModel> entityLstToModelLst(Collection<Users> r) {
        Type listType = new TypeToken<Collection<UsersModel>>(){}.getType();
        List<UsersModel> UsersModelList = modelMapper.map(r,listType);
        return UsersModelList;
    }

    @Override
    public Page<UsersModel> entityToModel(Page<Users> r) {
        return null;
    }
}
