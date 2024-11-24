package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffDao  extends JpaRepository<StaffEntity, String> {
    Optional<StaffEntity> findByFirstName(String name);
}
