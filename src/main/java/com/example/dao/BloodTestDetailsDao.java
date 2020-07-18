package com.example.dao;

import com.example.entity.BloodTestDetails;
import com.example.repository.BloodTestDetailsRepository;
import com.example.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class BloodTestDetailsDao implements Dao<BloodTestDetails> {

    @Autowired
    private BloodTestDetailsRepository bloodTestDetailsRepository;

    @Override
    public Optional<BloodTestDetails> get(Long id) {
        return bloodTestDetailsRepository.findById(id);
    }

    @Override
    public Collection<BloodTestDetails> getAll() {
        return bloodTestDetailsRepository.findAll();
    }

    @Override
    public BloodTestDetails save(BloodTestDetails bloodTestDetails) {
        return bloodTestDetailsRepository.save(bloodTestDetails);
    }

    @Override
    public BloodTestDetails update(BloodTestDetails bloodTestDetails) {
        return bloodTestDetailsRepository.save(bloodTestDetails);
    }

    @Override
    public void delete(BloodTestDetails bloodTestDetails) {
        bloodTestDetailsRepository.delete(bloodTestDetails);
    }

    @Override
    public void deleteById(Long id) {
        bloodTestDetailsRepository.deleteById(id);
    }

    @Override
    public Optional<BloodTestDetails> find(Long id) {
        return bloodTestDetailsRepository.findById(id);
    }

    @Override
    public Page<BloodTestDetails> findAll(Pageable pageable) {
        return null;
    }
}

