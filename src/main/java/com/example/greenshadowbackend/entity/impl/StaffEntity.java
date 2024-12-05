package com.example.greenshadowbackend.entity.impl;

import jakarta.persistence.*;
import com.example.greenshadowbackend.entity.SuperEntity;
import com.example.greenshadowbackend.enums.Designation;
import com.example.greenshadowbackend.enums.Gender;
import com.example.greenshadowbackend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity {
    @Id
    String id;
    String firstName;
    String lastName;
    String designation;
    @Enumerated(EnumType.STRING)
    Gender gender;
    Date joinedDate;
    Date dob;
    String address;
    String contact;
    String email;
    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "staff_field",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "field_code")
    )
    List<FieldEntity> fields;

    @OneToMany(mappedBy = "staff")
    List<VehicleEntity> vehicleEntities;

    @OneToMany(mappedBy = "staff")
    List<EquipmentEntity> equipmentEntityList;

    @OneToOne(mappedBy ="staffEntity")
    MonitoringLogEntity log;

}
