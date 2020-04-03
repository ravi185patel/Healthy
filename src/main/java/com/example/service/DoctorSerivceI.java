package com.example.service;

public interface DoctorSerivceI<T,R> extends ServiceI<T,R>{
    void deleteById(Long id);
}
