package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentDao extends JpaRepository<EquipmentEntity, String> {
    Optional<EquipmentEntity> findByName(String name);
}
