package com.example.repository;

import com.example.specification.TestListRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestDaoI<T> extends Dao<T>{
    Page<T> findAll(TestListRequest request,Pageable pageable);
}
