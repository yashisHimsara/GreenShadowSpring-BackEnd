package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldDto implements FieldStatus {
    private String FieldCode;
    private String FieldName;
    private Point location;
    private Double extent_size;
    private String image1;
    private String image2;
    private List<CropDto> cropDTOS;
    private List<String> staffIds;
}
