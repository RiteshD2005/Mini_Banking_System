package com.example.Mini_Banking.controller;

import com.example.Mini_Banking.dto.*;
import com.example.Mini_Banking.entity.Users;
import com.example.Mini_Banking.service.UsersService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserControllers {

    private final UsersService usersService;

    public UserControllers(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest request) {
        Users user = usersService.RegisterUser(request.email(), request.fullName(), request.username(), request.password(), request.phone());

        UserResponse response = new UserResponse(user.getId(), user.getFullName(), user.getEmail(), user.getUserName(), user.getPhone());

        return ResponseEntity.ok(response);
    }
}