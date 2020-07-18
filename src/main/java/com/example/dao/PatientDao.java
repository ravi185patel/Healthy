package com.example.dao;

import com.example.entity.Patient;
import com.example.repository.Dao;
import com.example.repository.PatientDaoI;
import com.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class PatientDao implements PatientDaoI<Patient> {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> get(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Collection<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Optional<Patient> find(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Patient> findByUserId(Long userId) {
        return patientRepository.findByUserId(userId);
    }
}
