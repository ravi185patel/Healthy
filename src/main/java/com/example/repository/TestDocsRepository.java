package com.example.repository;

import com.example.entity.TestDocs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDocsRepository extends JpaRepository<TestDocs,Long> {
}
