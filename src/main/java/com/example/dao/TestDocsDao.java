package com.example.dao;

import com.example.entity.TestDocs;
import com.example.repository.Dao;
import com.example.repository.TestDocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class TestDocsDao implements Dao<TestDocs> {

    @Autowired
    private TestDocsRepository TestDocsRepository;

    @Override
    public Optional<TestDocs> get(Long id) {
        return TestDocsRepository.findById(id);
    }

    @Override
    public Collection<TestDocs> getAll() {
        return TestDocsRepository.findAll();
    }

    @Override
    public TestDocs save(TestDocs TestDocs) {
        System.out.println(TestDocs.getTestDocName()+" test name for testDocs");
        return TestDocsRepository.save(TestDocs);
    }

    @Override
    public TestDocs update(TestDocs TestDocs) {
        return TestDocsRepository.save(TestDocs);
    }

    @Override
    public void delete(TestDocs TestDocs) {
        TestDocsRepository.delete(TestDocs);
    }

    @Override
    public void deleteById(Long id) {
        TestDocsRepository.deleteById(id);
    }

    @Override
    public Optional<TestDocs> find(Long id) {
        return TestDocsRepository.findById(id);
    }

    @Override
    public Page<TestDocs> findAll(Pageable pageable) {
        return null;
    }
}
