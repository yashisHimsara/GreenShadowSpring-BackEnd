package com.example.greenshadowbackend.CustomStatusCode;

import com.example.greenshadowbackend.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorStatusCodes implements CropStatus, EquipmentStatus, FieldStatus, LogStatus, StaffStatus,UserStatus, VehicleStatus {
    private int statusCode;
    private String statusMessage;
}
