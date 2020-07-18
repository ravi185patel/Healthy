package com.example.mapperImp;

import com.example.entity.Account;
import com.example.mapper.MapperInterface;
import com.example.model.AccountModel;
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
public class AccountMapper implements MapperInterface<AccountModel, Account> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Account modelToEntity(AccountModel AccountModel) {
        return modelMapper.map(AccountModel,Account.class);
    }

    @Override
    public AccountModel entityToModel(Account Account) {
        return modelMapper.map(Account,AccountModel.class);
    }

    @Override
    public Collection<Account> modelLstToEntityLst(Collection<AccountModel> t) {
        List<Account> AccountList=new ArrayList<Account>();
        t.stream().forEach(AccountModel -> {
            AccountList.add(modelToEntity(AccountModel));
        });
        return AccountList;
    }

    @Override
    public List<AccountModel> entityLstToModelLst(Collection<Account> r) {
        Type listType = new TypeToken<Collection<AccountModel>>(){}.getType();
        List<AccountModel> AccountModelList = modelMapper.map(r,listType);
        return AccountModelList;
    }

    @Override
    public Page<AccountModel> entityToModel(Page<Account> r) {
        return null;
    }
}
