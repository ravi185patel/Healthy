package com.example.service;

public interface BloodTestDetailsSerivceI<T> extends ServiceI<T>{
    void deleteById(Long id);
}
