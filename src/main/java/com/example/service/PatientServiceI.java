package com.example.service;

public interface PatientServiceI<T,R> extends ServiceI<T,R>{
    void deleteById(Long id);
}
