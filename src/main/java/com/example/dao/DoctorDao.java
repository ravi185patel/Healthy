package com.example.dao;

import com.example.entity.Doctor;
import com.example.repository.Dao;
import com.example.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class DoctorDao implements Dao<Doctor> {

    @Autowired
    private DoctorRepository DoctorRepository;

    @Override
    public Optional<Doctor> get(Long id) {
        return DoctorRepository.findById(id);
    }

    @Override
    public Collection<Doctor> getAll() {
        return DoctorRepository.findAll();
    }

    @Override
    public Doctor save(Doctor Doctor) {
        return DoctorRepository.save(Doctor);
    }

    @Override
    public Doctor update(Doctor Doctor) {
        return DoctorRepository.save(Doctor);
    }

    @Override
    public void delete(Doctor Doctor) {
        DoctorRepository.delete(Doctor);
    }

    @Override
    public void deleteById(Long id) {
        DoctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> find(Long id) {
        return DoctorRepository.findById(id);
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {
        return null;
    }
}

