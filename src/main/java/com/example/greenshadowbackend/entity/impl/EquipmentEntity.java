package com.example.greenshadowbackend.entity.impl;


import com.example.greenshadowbackend.entity.SuperEntity;
import com.example.greenshadowbackend.enums.EquipmentsStatus;
import com.example.greenshadowbackend.enums.EquipmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {
    @Id
    String EquipmentId;
    String name;
    @Enumerated(EnumType.STRING)
    EquipmentType equipmentType;
    @Enumerated(EnumType.STRING)
    EquipmentsStatus status;

    @ManyToOne
    @JoinColumn(name = "id")
    StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "field_code")
    FieldEntity field;
}
