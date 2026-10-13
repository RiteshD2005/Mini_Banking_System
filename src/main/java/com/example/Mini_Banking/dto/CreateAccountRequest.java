package com.example.Mini_Banking.dto;

import java.util.UUID;

import com.example.Mini_Banking.entity.Accounts;

public record CreateAccountRequest(UUID userId,Accounts.AccType account_type) {
}
