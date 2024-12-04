package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.StaffStatus;
import com.example.greenshadowbackend.dto.impl.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    List<StaffDto> getAllStaffs();
    StaffStatus getStaff(String staffId);
    void deleteStaff(String staffId);
    void updateStaff(String staffId, StaffDto staffDTO);
}
