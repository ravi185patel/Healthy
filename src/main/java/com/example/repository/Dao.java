package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);
    Collection<T> getAll();
    T save(T t);
    T update(T t);
    void delete(T t);
    void deleteById(Long id);
    Optional<T> find(Long id);
    Page<T> findAll(Pageable pageable);
}
