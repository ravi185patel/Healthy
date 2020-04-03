package com.example.service;

public interface AdminServiceI<T,R> extends ServiceI<T,R>{
//    R add(T t);
    void delete(T t);
    void deleteById(Long id);
}
