package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto implements VehicleStatus {
    private String vehicleCode;
    private String licensePlateNum;
    private String category;
    private String fuel_type;
    private String status;
    private String remarks;
    private String staffId;
}
