package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.CropStatus;
import com.example.greenshadowbackend.entity.impl.FieldEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDto implements CropStatus {
    private String cropCode;
    private String commonName;
    private String scientificName;
    private String image;
    private String category;
    private String season;
    private FieldDto fieldDto;
}
