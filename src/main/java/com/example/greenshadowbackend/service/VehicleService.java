package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.VehicleStatus;
import com.example.greenshadowbackend.dto.impl.VehicleDto;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getAllVehicle();

    void deleteVehicle(String vehicleCode);

    void updateVehicle(String vehicleCode, VehicleDto vehicleDto);

    VehicleStatus getSelectedVehicleByLicensePlateNum(String licensePlateNum);

}