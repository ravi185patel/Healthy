package com.example.service;


import com.example.specification.TestListRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestSerivceI<T> extends ServiceI<T>{
    void deleteById(Long id);
    Page<T> findAll(TestListRequest request,Pageable pageable);
}
