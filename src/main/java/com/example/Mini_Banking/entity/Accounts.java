package com.example.Mini_Banking.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "Account")
public class Accounts {

    public enum AccType {
        Saving_Account,
        Current_Account
    }

    @Id
    @Column(name = "Account_id", columnDefinition = "uuid")
    private UUID accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "Account_number", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name = "Pin", nullable = false)
    private String pin;

    @Enumerated(EnumType.STRING)
    @Column(name = "Account_Type", nullable = false)
    private AccType accountType;

    @Column(name = "Account_Balance")
    private double currentBalance;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreated() {
        if (accountId == null) {
            this.accountId = UUID.randomUUID();
        }
    }
}
