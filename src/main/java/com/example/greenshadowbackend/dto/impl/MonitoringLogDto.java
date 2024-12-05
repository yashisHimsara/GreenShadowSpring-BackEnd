package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.LogStatus;
import com.example.greenshadowbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringLogDto implements LogStatus {
    String logCode;
    Date date;
    String observation;
    String observationImage;
    FieldDto fieldDto;
    StaffDto staffDto;
    CropDto cropDto;
}
