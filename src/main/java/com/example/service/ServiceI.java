package com.example.service;

import java.util.List;

public interface ServiceI<T,R> {
//    R add(T t);
    R get(Long id);
    List<R> getAll();
    R add(T t);
//    R delete(T t);
//    R delete(Long id);
    R update(T t);
}
