package com.example.repository;

import com.example.entity.BloodTestDetails;
import com.example.entity.BloodTestMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodTestDetailsRepository extends JpaRepository<BloodTestDetails,Long> {
}
