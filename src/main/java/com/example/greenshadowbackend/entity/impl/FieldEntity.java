package com.example.greenshadowbackend.entity.impl;


import jakarta.persistence.*;
import com.example.greenshadowbackend.dto.impl.CropDto;
import com.example.greenshadowbackend.dto.impl.StaffDto;
import com.example.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldCode;
    @Column(unique = true)
    private String fieldName;
    private Point location;
    private Double extentSize;
    @Column(columnDefinition = "LONGTEXT")
    private String image1;
    @Column(columnDefinition = "LONGTEXT")
    private String image2;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CropEntity> crops;

    @OneToMany(mappedBy = "field",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<StaffEntity> staffs;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "FieldEquipment",
            joinColumns = @JoinColumn(name = "fieldId"),
            inverseJoinColumns = @JoinColumn(name = "equipmentId")
    )
    private List<EquipmentEntity> equipment;

    @OneToMany(mappedBy = "fields",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MonitoringLogEntity> logs;
}