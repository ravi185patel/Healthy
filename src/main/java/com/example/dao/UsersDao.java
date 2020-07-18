package com.example.dao;

import com.example.entity.Users;
import com.example.repository.Dao;
import com.example.repository.LoginDao;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class UsersDao implements Dao<Users>, LoginDao<Users> {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Optional<Users> get(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Collection<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<Users> find(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Users find(Object obj) {
        Optional<Users> optionalUser=usersRepository.findByUserName((String) obj);
        if(!optionalUser.isPresent()){
            throw new NullPointerException();
        }
        return optionalUser.get();
    }

    public boolean isUsernameAlreadyInUse(String name){
        return usersRepository.findByUserName(name).isPresent();
    }

    public boolean isEmailAlreadyInUse(String emailId){
        return usersRepository.findByEmail(emailId).isPresent();
    }

    public Users findByUserName(String emailId) {
        Optional<Users> optionalUser=usersRepository.findByUserName(emailId);
        if(!optionalUser.isPresent()){
            throw new NullPointerException();
        }
        return optionalUser.get();
    }
}
