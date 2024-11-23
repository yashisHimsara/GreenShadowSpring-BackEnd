package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.StaffStatus;
import com.example.greenshadowbackend.dto.impl.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);

    List<StaffDto> getAllStaff();

    void deleteStaff(String staffId);

    void updateStaff(String staffId, StaffDto staffDto );

    StaffStatus getSelectedStaffMemberByName(String name);
}
