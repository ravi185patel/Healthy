package com.example.service;

import java.util.List;

public interface ServiceI<T> {
    T get(Long id);
    List<T> getAll();
    T add(T t);
    T update(T t);
}
