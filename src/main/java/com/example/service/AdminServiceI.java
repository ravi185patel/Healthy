package com.example.service;

public interface AdminServiceI<T> extends ServiceI<T>{
//    R add(T t);
    void delete(T t);
    void deleteById(Long id);
}
