package com.example.greenshadowbackend.entity.impl;

import jakarta.persistence.*;
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
    String fieldCode;
    String fieldName;
    String fieldLocation;
    double fieldSize;

    @Column(columnDefinition = "LONGTEXT")
    String fieldImage;

    @Column(columnDefinition = "LONGTEXT")
    String fieldImage2;

    @OneToMany(mappedBy = "fieldEntity", cascade = CascadeType.ALL)
    List<CropEntity> cropEntityList;

    @ManyToMany(mappedBy = "fields", cascade = {CascadeType.PERSIST})
    List<StaffEntity> staffEntityList;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    List<EquipmentEntity> equipmentEntityList;

    @OneToMany(mappedBy = "fieldEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<MonitoringLogEntity> logEntityList;
}
