package com.example.repository;

import com.example.entity.BloodTestMaster;
import com.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodTestMasterRepository extends JpaRepository<BloodTestMaster,Long> {
}
