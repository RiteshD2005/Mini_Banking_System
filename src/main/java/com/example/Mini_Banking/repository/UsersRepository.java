package com.example.Mini_Banking.repository;

import com.example.Mini_Banking.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Optional<Users> findByEmail(String email);
}