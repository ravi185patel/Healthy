package com.example.dao;

import com.example.entity.Account;
import com.example.repository.Dao;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class AccountDao implements Dao<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<Account> get(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Collection<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account Account) {
        return accountRepository.save(Account);
    }

    @Override
    public Account update(Account Account) {
        return accountRepository.save(Account);
    }

    @Override
    public void delete(Account Account) {
        accountRepository.delete(Account);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> find(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }
}
