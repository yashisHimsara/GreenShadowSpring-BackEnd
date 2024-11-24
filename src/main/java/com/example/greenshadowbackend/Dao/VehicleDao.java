package com.example.greenshadowbackend.Dao;

import com.example.greenshadowbackend.entity.impl.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleDao extends JpaRepository<VehicleEntity, String> {

    Optional<VehicleEntity> findByLicensePlateNum(String licensePlateNum);
}
