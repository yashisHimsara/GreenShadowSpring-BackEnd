package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.EquipmentStatus;
import com.example.greenshadowbackend.enums.EquipmentType;
import com.example.greenshadowbackend.enums.EquipmentsStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto implements EquipmentStatus {
  String EquipmentId;
  String name;
  @Enumerated(EnumType.STRING)
  EquipmentType equipmentType;
  @Enumerated(EnumType.STRING)
  EquipmentsStatus status;
  StaffDto staff;
   FieldDto field;
}
