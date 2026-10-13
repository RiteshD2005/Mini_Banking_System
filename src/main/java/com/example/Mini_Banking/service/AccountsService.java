package com.example.Mini_Banking.service;

import com.example.Mini_Banking.repository.*;
import jakarta.transaction.Transactional;
import com.example.Mini_Banking.entity.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountsService {

    private final AccountsRepository accountsRepository;
    private final UsersRepository usersRepository;

    public AccountsService(AccountsRepository accountsRepository, UsersRepository usersRepository) {
        this.accountsRepository = accountsRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Accounts createAccounts(UUID userId, Accounts.AccType type) {

        Users user = usersRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User Not Found"));

        Accounts newAcc = new Accounts();
        newAcc.setUser(user);
        newAcc.setCurrentBalance(0.00);
        newAcc.setAccountType(type);
        newAcc.setAccountNumber(generateAccNumber());

        return accountsRepository.save(newAcc);
    }

    private long generateAccNumber() {
        long accNum;
        do {
            accNum = 100000L + (long) (Math.random() * 9000000000L);
        } while (accountsRepository.existsByAccountNumber(accNum));
        return accNum;
    }
}
