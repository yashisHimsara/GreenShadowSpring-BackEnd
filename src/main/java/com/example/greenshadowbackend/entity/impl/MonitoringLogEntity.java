package com.example.greenshadowbackend.entity.impl;

import jakarta.persistence.*;
import com.example.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "log")
public class MonitoringLogEntity implements SuperEntity {
    @Id
    private String log_code;
    @Column(unique = true)
    private String tempId;
    private Date date;
    private String details;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "fieldId", nullable = false)
    private FieldEntity fields;
    @ManyToOne
    @JoinColumn(name = "cropId", nullable = false)
    private CropEntity crops;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private StaffEntity staffs;


}