package com.example.greenshadowbackend.entity.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperDTO {
    @Id
    private String equipmentId;
    @Column(unique = true)
    private String name;
    private String status;
    private String type;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity field;
}
