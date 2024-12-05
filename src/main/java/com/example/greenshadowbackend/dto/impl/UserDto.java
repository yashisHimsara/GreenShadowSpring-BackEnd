package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import com.example.greenshadowbackend.dto.UserStatus;
import com.example.greenshadowbackend.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
