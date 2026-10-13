package com.example.Mini_Banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "Users")
public class Users {

    public enum Role {
        User,
        Admin
    }

    @Id
    @Column(name = "User_id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "Full_name", nullable = false)
    private String fullName;

    @Column(name = "User_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_phone", nullable = false)
    private String phone;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Users() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}   