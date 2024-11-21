package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto implements EquipmentStatus {
  private String EquipmentId;
  private String name;
  private String type;
  private String status;
  private String staffId;
  private String fieldId;
}
