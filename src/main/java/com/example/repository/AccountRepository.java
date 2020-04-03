package com.example.repository;

import com.example.entity.Account;
import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Users> findByUserName(String firstname);
}
