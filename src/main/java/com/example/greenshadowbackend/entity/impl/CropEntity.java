package com.example.greenshadowbackend.entity.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Crop")

public class CropEntity implements SuperDTO {
    @Id
    private String cropCode;
    @Column(unique = true)
    private String commonName;
    private String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String category;
    private String season;
    @ManyToOne
    @JoinColumn(name = "field_code",nullable = false)
    private FieldEntity field;
    @ManyToMany(mappedBy = "crops", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MonitoringLogEntity> logs;
}
