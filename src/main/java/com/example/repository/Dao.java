package com.example.repository;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);
    Collection<T> getAll();
    T save(T t);
    void update(T t);
    void delete(T t);
    void deleteById(Long id);
    T find(Long id);
}
