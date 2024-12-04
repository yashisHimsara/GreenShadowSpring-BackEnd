package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.VehicleStatus;
import com.example.greenshadowbackend.dto.impl.VehicleDto;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();
    VehicleStatus getVehicle(String vehicleId);
    void deleteVehicle(String vehicleId);
    void updateVehicle(String vehicleId, VehicleDto vehicleDto);

}