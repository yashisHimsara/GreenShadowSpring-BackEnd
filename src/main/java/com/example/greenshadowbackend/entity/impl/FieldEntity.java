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

    @OneToMany(mappedBy = "field")
    private List<CropEntity> cropDTOS;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "staff_field_details",
            joinColumns = @JoinColumn(name = "field_code"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<StaffEntity> staffs;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<EquipmentEntity> equipment;
    @ManyToMany(mappedBy = "fields", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MonitoringLogEntity> logs;
}