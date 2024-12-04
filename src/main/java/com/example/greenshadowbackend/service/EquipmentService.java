package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.EquipmentStatus;
import com.example.greenshadowbackend.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDto equipmentDto);
    List<EquipmentDto> getAllEquipment();
    EquipmentStatus getEquipment(String equipmentId);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId, EquipmentDto equipmentDto);
}
