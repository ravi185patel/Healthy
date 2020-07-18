package com.example.dao;

import com.example.entity.Test;
import com.example.repository.Dao;
import com.example.repository.TestDaoI;
import com.example.repository.TestRepository;
import com.example.specification.TestListRequest;
import com.example.specification.TestListSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

@Repository
public class TestDao implements TestDaoI<Test> {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestListSpecification testListSpecification;

    @Override
    public Optional<Test> get(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public Collection<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test update(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }

    @Override
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public Optional<Test> find(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public Page<Test> findAll(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

    @Override
    public Page<Test> findAll(TestListRequest request, Pageable pageable) {
        return testRepository.findAll(testListSpecification.getFilter(request),pageable);
    }
}

