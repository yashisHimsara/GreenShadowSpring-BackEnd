package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropDao extends JpaRepository<CropEntity, String> {

    Optional<CropEntity> findByCommonName(String name);
}
