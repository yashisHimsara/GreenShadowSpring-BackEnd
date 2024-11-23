package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.impl.CropDto;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    List<CropDto> grtAllCrops();
    void deleteCrop(String cropCode);
    void updateCrop(String cropcode, CropDto cropDto);
    CropDto getSelectedCropByName(String name);
}
