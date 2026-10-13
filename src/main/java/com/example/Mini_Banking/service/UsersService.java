package com.example.Mini_Banking.service;

import com.example.Mini_Banking.repository.*;
import jakarta.transaction.Transactional;
import com.example.Mini_Banking.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersService(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public Users RegisterUser(String email, String fullName, String username, String password, String phone) {
        if (usersRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("user already exists");
        }

        if (usersRepository.existsByUserName(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        String hashPassword = bCryptPasswordEncoder.encode(password);

        Users user = new Users();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(hashPassword);
        user.setPhone(phone);
        user.setUserName(username);
        user.setRole(Users.Role.User);

        return usersRepository.save(user);
    }
}