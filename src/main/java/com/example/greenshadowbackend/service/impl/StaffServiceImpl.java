package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.StaffDao;
import com.example.greenshadowbackend.dto.StaffStatus;
import com.example.greenshadowbackend.dto.impl.StaffDto;
import com.example.greenshadowbackend.entity.impl.StaffEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.StaffNotFoundException;
import com.example.greenshadowbackend.service.StaffService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private Mapping staffMapping;
    @Override
    public void saveStaff(StaffDto staffDto) {
        staffDto.setStaffId(AppUtil.generateStaffCode());
        StaffEntity saveStaff=staffDao.save(staffMapping.toStaffEntity(staffDto));
        if (saveStaff!=null) {
            throw new DataPersistException("Staff not saved");
        }
    }

    @Override
    public List<StaffDto> getAllStaffs() {
        return staffMapping.asStaffDtoList(staffDao.findAll());
    }

    @Override
    public StaffStatus getStaff(String staffId) {
        if (staffDao.existsById(staffId)){
            var selectedStaff=staffDao.getReferenceById(staffId);
            return staffMapping.toStaffDTO(selectedStaff);
        }else {
            return new ErrorStatusCodes(1,"Selected Staff not found");
        }
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<StaffEntity> selectedStaff=staffDao.findById(staffId);
        if (!selectedStaff.isPresent()){
            throw new DataPersistException("Selected Staff not found");
        }else {
            staffDao.deleteById(staffId);
        }

    }

    @Override
    public void updateStaff(String staffId, StaffDto staffDTO) {
        Optional<StaffEntity> findStaff=staffDao.findById(staffId);
        if (!findStaff.isPresent()){
            throw new StaffNotFoundException("Selected Staff not found");
        }else {
            findStaff.get().setFirstName(staffDTO.getFirstName());
            findStaff.get().setLastName(staffDTO.getLastName());
            findStaff.get().setDesignation(staffDTO.getDesignation());
            findStaff.get().setGender(staffDTO.getGender());
            findStaff.get().setJoinedDate(staffDTO.getJoinedDate());
            findStaff.get().setDob(staffDTO.getDob());
            findStaff.get().setAddress1(staffDTO.getAddress1());
            findStaff.get().setAddress2(staffDTO.getAddress2());
            findStaff.get().setAddress3(staffDTO.getAddress3());
            findStaff.get().setAddress4(staffDTO.getAddress4());
            findStaff.get().setAddress5(staffDTO.getAddress5());
            findStaff.get().setContactNo(staffDTO.getContactNo());
            findStaff.get().setEmail(staffDTO.getEmail());
            findStaff.get().setRole(staffDTO.getRole());
        }
    }
}
