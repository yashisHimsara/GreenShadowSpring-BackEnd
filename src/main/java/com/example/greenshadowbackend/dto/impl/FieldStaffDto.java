package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.FieldStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldStaffDto implements FieldStatus {
    private String FieldCode;
    private String staffId;
}
