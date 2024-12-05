package com.example.greenshadowbackend.entity.impl;

import jakarta.persistence.*;
import com.example.greenshadowbackend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "log")
public class MonitoringLogEntity implements SuperEntity {

    @Id
    String logCode;

    Date date;
    String observation;

    @Column(columnDefinition = "LONGTEXT")
    String observationImage;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "field_code")
    FieldEntity fieldEntity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_code")
    CropEntity cropEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    StaffEntity staffEntity;
}
