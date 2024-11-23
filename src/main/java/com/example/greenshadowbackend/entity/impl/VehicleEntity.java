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
@Table(name = "vehicle")
public class VehicleEntity implements SuperEntity {
    @Id
    private String vehicle_code;
    @Column(unique = true)
    private String licensePlateNum;
    private String category;
    private String fuel_type;
    private String status;
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private StaffEntity staff;
}