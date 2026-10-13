package com.example.Mini_Banking.repository;

import com.example.Mini_Banking.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, UUID> {
    boolean existsByAccountNumber(Long accountNumber);
    boolean existsByUser(Users user);
    Optional<Accounts> findByAccountNumber(Long accountNumber);
}