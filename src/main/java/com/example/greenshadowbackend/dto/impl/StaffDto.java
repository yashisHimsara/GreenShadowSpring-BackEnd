package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.StaffStatus;
import com.example.greenshadowbackend.enums.Designation;
import com.example.greenshadowbackend.enums.Gender;
import com.example.greenshadowbackend.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto implements StaffStatus {
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
    List<FieldDto> fields;

}
