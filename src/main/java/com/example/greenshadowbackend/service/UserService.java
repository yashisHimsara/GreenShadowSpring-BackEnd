package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.UserStatus;
import com.example.greenshadowbackend.dto.impl.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserStatus getUser(String userId);
    void deleteUser(String userId);
    void updateUser(String userId, UserDto userDto);
}
