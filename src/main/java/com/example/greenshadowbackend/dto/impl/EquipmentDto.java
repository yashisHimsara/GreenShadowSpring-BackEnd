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
  private String equipmentId;
  private String name;
  private String status;
  private String type;
  private String field_code;
  private String staffId;
}
