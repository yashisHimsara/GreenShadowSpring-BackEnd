package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.CropStatus;
import com.example.greenshadowbackend.dto.impl.CropDto;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    List<CropDto> getAllCrops();
    CropStatus getCrop(String cropId);
    void deleteCrop(String cropId);
    void updateCrop(String cropId, CropDto cropDto);
}
