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
    private String id;
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private Designation designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    //    private List<String> addresses;
    private String contactNo;
    @Column(unique = true)
    private String email;
    private Role role;
    @ManyToMany(mappedBy = "staffs", cascade = CascadeType.ALL)
    private List<FieldEntity> fields;
    @OneToMany(mappedBy = "staff")
    private List<VehicleEntity> vehicles;
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<EquipmentEntity> equipment;
    @ManyToMany(mappedBy = "staffs", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MonitoringLogEntity> logs;

}
