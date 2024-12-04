package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import com.example.greenshadowbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements SuperDTO {
    private String user_id;
    private String email;
    private String password;
    private Role role;
}
