package com.example.service;

public interface UsersServiceI<T> extends ServiceI<T>{
    T add(T t);
    T get(Long id);
    T get(String email);
}
