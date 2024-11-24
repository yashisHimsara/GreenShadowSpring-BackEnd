package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogMonitoringDao extends JpaRepository<FieldEntity, String> {
    Optional<FieldEntity> findByFieldName(String name);

}
