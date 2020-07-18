package com.example.service;

public interface DoctorSerivceI<T> extends ServiceI<T>{
    void deleteById(Long id);
}
