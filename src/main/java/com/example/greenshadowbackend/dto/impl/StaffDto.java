package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.StaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto implements StaffStatus {
    private String id;
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
    private String contactNo;
    private String email;
    private Role role;
    private List<FieldDto> fields;
    private List<VehicleDto> vehicles;

}
