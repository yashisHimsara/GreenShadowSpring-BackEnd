package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDto equipmentDto);

    List<EquipmentDto> getAllEquipment();

    void deleteEquipment(String equipmentId);

    void updateEquipment(String equipmentId, EquipmentDto equipmentDto);

    EquipmentDto getSelectedEquipmentByName(String name);
}
