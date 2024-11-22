package com.example.greenshadowbackend.dto.impl;

import com.example.greenshadowbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringLogDto implements SuperDTO {
    private String logCode;
    private Date logDate;
    private String logDetails;
    private String image;
    private List<FieldDto> fields;
    private List<CropDto> crops;
    private List<StaffDto> staffs;
}
