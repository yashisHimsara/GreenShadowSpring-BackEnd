package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.FieldStatus;
import com.example.greenshadowbackend.dto.impl.FieldDto;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);
    List<FieldDto> getAllFields();
    FieldStatus getField(String fieldId);
    void deleteField(String fieldId);
    void updateField(String fieldId, FieldDto fieldDto);
}
