package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.VehicleDao;
import com.example.greenshadowbackend.dto.VehicleStatus;
import com.example.greenshadowbackend.dto.impl.VehicleDto;
import com.example.greenshadowbackend.entity.impl.VehicleEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.VehicleNotFoundException;
import com.example.greenshadowbackend.service.VehicleService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private Mapping vehicleMapping;
    @Override
    public void saveVehicle(VehicleDto vehicleDto) {
        vehicleDto.setVehicleCode(AppUtil.generateVehicleCode());
        VehicleEntity saveVehicle=vehicleDao.save(vehicleMapping.toVehicleEntity(vehicleDto));
        if (saveVehicle!=null) {
            throw new DataPersistException("Vehicle not saved");
        }
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleMapping.asVehicleDtoList(vehicleDao.findAll());
    }

    @Override
    public VehicleStatus getVehicle(String vehicleId) {
        if (vehicleDao.existsById(vehicleId)){
            var selectedVehicle=vehicleDao.getReferenceById(vehicleId);
            return vehicleMapping.toVehicleDto(selectedVehicle);
        }else {
            return new ErrorStatusCodes(1,"Selected Vehicle not found");
        }
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Optional<VehicleEntity> selectedVehicle=vehicleDao.findById(vehicleId);
        if (!selectedVehicle.isPresent()){
            throw new VehicleNotFoundException("Selected Vehicle not found");
        }else {
            vehicleDao.deleteById(vehicleId);
        }
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDto vehicleDto) {
        Optional<VehicleEntity> findVehicle=vehicleDao.findById(vehicleId);
        if (!findVehicle.isPresent()){
            throw new VehicleNotFoundException("Selected Vehicle not found");
        }else {
            findVehicle.get().setLicensePlateNum(vehicleDto.getLicensePlateNum());
            findVehicle.get().setCategory(vehicleDto.getCategory());
            findVehicle.get().setFuelType(vehicleDto.getFuelType());
            findVehicle.get().setStatus(vehicleDto.getStatus());
            findVehicle.get().setRemarks(vehicleDto.getRemarks());
        }

    }
}
