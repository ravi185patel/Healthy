package com.example.service;

public interface BloodTestMasterSerivceI<T> extends ServiceI<T>{
    void deleteById(Long id);
}
