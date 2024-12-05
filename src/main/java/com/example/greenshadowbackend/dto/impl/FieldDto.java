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
    String fieldCode;
    String fieldName;
    String fieldLocation;
    double  fieldSize;
    String fieldImage;
    String fieldImage2;
}
