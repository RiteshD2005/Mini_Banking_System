package com.example.Mini_Banking.service;

import org.springframework.stereotype.Service;

import com.example.Mini_Banking.repository.*;

import jakarta.transaction.Transactional;

@Service 
public class TransactionsService {
    
    private final TransactionsRepository transactionsRepository;
    private final UsersRepository usersRepository;
    private final AccountsRepository accountsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository, UsersRepository usersRepository , AccountsRepository accountRepository){
        this.transactionsRepository = transactionsRepository;
        this.accountsRepository = accountRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void Transfermoney(){
        // will make it in future
    }
}