package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {

}
