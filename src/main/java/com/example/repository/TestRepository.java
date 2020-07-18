package com.example.repository;

import com.example.entity.Test;
import com.example.specification.TestListRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestRepository extends JpaRepository<Test,Long>, JpaSpecificationExecutor<Test> {
    Page<Test> findAll(Pageable pageable);
}
