package com.example.service;

public interface TestDocsServiceI<T> extends ServiceI<T>{
    void deleteById(Long id);
}
