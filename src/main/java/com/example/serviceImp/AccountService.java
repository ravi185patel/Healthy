package com.example.serviceImp;

import com.example.dao.AccountDao;
import com.example.entity.Account;
import com.example.mapper.MapperInterface;
import com.example.model.AccountModel;
import com.example.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements ServiceI<AccountModel> {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MapperInterface<AccountModel, Account> accountMapper;

    @Override
    public AccountModel get(Long id) {
        return null;
    }

    @Override
    public List<AccountModel> getAll() {
        return null;
    }

    @Transactional(rollbackOn = Exception.class,value = Transactional.TxType.REQUIRED)
    @Override
    public AccountModel add(AccountModel accountModel) {
        return null;
    }

    @Transactional(rollbackOn = Exception.class,value = Transactional.TxType.REQUIRED)
    @Override
    public AccountModel update(AccountModel accountModel) {
        return null;
    }

    public boolean isEmailAlreadyInUse(String email){
        return true;
    }
}
