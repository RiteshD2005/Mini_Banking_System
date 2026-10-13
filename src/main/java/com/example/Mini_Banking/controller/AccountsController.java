package com.example.Mini_Banking.controller;

import com.example.Mini_Banking.service.AccountsService;
import com.example.Mini_Banking.dto.AccountResponse;
import com.example.Mini_Banking.dto.CreateAccountRequest;
import com.example.Mini_Banking.entity.Accounts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }
    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest request) {
        Accounts account = accountsService.createAccounts(request.userId(), request.account_type());

        AccountResponse response = new AccountResponse(
            account.getAccountId(),
            account.getAccountNumber(),
            account.getAccountType(),
            account.getCurrentBalance()
        );

        return ResponseEntity.ok(response);
    }
}
