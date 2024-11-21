package com.example.greenshadowbackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {
    private String FieldCode;
    private String FieldName;
    private Point location;
    private Double extent_size;
    private String image1;
    private String image2;
    private List<CropDto> cropDTOS;
    private List<String> staffIds;
}
