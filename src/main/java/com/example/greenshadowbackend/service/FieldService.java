package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.impl.FieldDto;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);

    List<FieldDto> getAllFields();

    void updateField(String fieldCode, FieldDto fieldDto);

    void deleteField(String fieldCode);

    FieldDto getSelectedFieldByName(String name);

//    void saveFieldStaff(FieldStaffDto fieldStaffDto0);
//
//    void deleteFieldStaff(String fieldCode, String staffId);
}
