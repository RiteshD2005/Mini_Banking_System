package com.example.Mini_Banking.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "Transactions")
public class Transactions {

    public enum Status {
        PENDING,
        SUCCESFULL,
        FAILED
    }

    @Id
    @Column(name = "Transaction_id", columnDefinition = "uuid")
    private UUID transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sender_id", nullable = false)
    private Accounts sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Receiver_id", nullable = false)
    private Accounts receiver;

    @Column(name = "Amount", nullable = false)
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private Status status = Status.PENDING;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreated() {
        if (transactionId == null) {
            this.transactionId = UUID.randomUUID();
        }
    }
}
