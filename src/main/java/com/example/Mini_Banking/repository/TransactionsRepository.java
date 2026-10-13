package com.example.Mini_Banking.repository;

import com.example.Mini_Banking.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, UUID> {

    boolean existsByTransactionId(UUID transactionId);

    List<Transactions> findBySenderAccountId(UUID senderId);
    List<Transactions> findByReceiverAccountId(UUID receiverId);

}
