package com.example.repository;


public interface LoginDao<T> {
    T find(Object obj);
}
