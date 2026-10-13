package com.example.Mini_Banking.dto;

import java.util.UUID;

public record UserResponse(UUID id, String fullName, String email, String user_name, String phone){
    
}