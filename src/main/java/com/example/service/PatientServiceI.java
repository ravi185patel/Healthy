package com.example.service;

public interface PatientServiceI<T> extends ServiceI<T>{
    void deleteById(Long id);
    T getByUserId(Long id);
}
