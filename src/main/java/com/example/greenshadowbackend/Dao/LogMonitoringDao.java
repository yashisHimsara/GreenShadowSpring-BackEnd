package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.FieldEntity;
import com.example.greenshadowbackend.entity.impl.MonitoringLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogMonitoringDao extends JpaRepository<MonitoringLogEntity, String> {
//    Optional<FieldEntity> findByFieldName(String name);

}
