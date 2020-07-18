package com.example.dao;

import com.example.entity.BloodTestMaster;
import com.example.repository.Dao;
import com.example.repository.BloodTestMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class BloodTestMasterDao implements Dao<BloodTestMaster> {

    @Autowired
    private BloodTestMasterRepository bloodTestMasterRepository;

    @Override
    public Optional<BloodTestMaster> get(Long id) {
        return bloodTestMasterRepository.findById(id);
    }

    @Override
    public Collection<BloodTestMaster> getAll() {
        return bloodTestMasterRepository.findAll();
    }

    @Override
    public BloodTestMaster save(BloodTestMaster bloodTestMaster) {
        return bloodTestMasterRepository.save(bloodTestMaster);
    }

    @Override
    public BloodTestMaster update(BloodTestMaster bloodTestMaster) {
        return bloodTestMasterRepository.save(bloodTestMaster);
    }

    @Override
    public void delete(BloodTestMaster bloodTestMaster) {
        bloodTestMasterRepository.delete(bloodTestMaster);
    }

    @Override
    public void deleteById(Long id) {
        bloodTestMasterRepository.deleteById(id);
    }

    @Override
    public Optional<BloodTestMaster> find(Long id) {
        return bloodTestMasterRepository.findById(id);
    }

    @Override
    public Page<BloodTestMaster> findAll(Pageable pageable) {
        return null;
    }
}

