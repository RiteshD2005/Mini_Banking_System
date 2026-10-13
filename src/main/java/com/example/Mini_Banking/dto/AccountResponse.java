package com.example.Mini_Banking.dto;

import java.util.UUID;

import com.example.Mini_Banking.entity.Accounts.AccType;

public record AccountResponse (UUID account_id, long account_number, AccType account_type, double current_balance) {

}
