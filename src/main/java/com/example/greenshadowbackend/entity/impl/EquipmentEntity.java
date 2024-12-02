package com.example.greenshadowbackend.entity.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToMany(mappedBy = "equipment", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StaffEntity> staff;
    @ManyToMany(mappedBy = "equipment", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private List<FieldEntity> fields;
}
