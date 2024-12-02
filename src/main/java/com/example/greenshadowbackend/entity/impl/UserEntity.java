package com.example.greenshadowbackend.entity.impl;

import com.example.greenshadowbackend.entity.SuperEntity;
import com.example.greenshadowbackend.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
    private Role role;

}

