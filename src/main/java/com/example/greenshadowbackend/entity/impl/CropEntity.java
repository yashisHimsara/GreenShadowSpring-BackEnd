package com.example.greenshadowbackend.entity.impl;

import com.example.greenshadowbackend.entity.SuperEntity;
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
public class CropEntity implements SuperEntity {

    @Id
    String cropCode;
    String commonName;
    String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    String image;
    String category;
    String season;

    @ManyToOne
    @JoinColumn(name = "field_code" )
    FieldEntity fieldEntity;

    @OneToMany(mappedBy = "cropEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<MonitoringLogEntity> logEntityList;
}
