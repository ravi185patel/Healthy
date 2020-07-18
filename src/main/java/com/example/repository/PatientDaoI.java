package com.example.repository;

import java.util.Optional;

public interface PatientDaoI<T> extends Dao<T>{
    Optional<T> findByUserId(Long userId);
}
