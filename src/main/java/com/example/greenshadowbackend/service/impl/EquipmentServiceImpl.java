package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.EquipmentDao;
import com.example.greenshadowbackend.dto.EquipmentStatus;
import com.example.greenshadowbackend.dto.impl.EquipmentDto;
import com.example.greenshadowbackend.entity.impl.EquipmentEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.service.EquipmentService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping equipmentMapping;

    @Override
    public void saveEquipment(EquipmentDto equipmentDto) {
        equipmentDto.setEquipmentId(AppUtil.generateEquipmentCode());
        EquipmentEntity saveEquipment=equipmentDao.save(equipmentMapping.toEquipmentEntity(equipmentDto));
        if (saveEquipment==null){
            throw new DataPersistException("Equipment not saved");
        }
    }

    @Override
    public List<EquipmentDto> getAllEquipment() {
        return equipmentMapping.asEquipmentDtoList(equipmentDao.findAll());
    }

    @Override
    public EquipmentStatus getEquipment(String equipmentId) {
        if (equipmentDao.existsById(equipmentId)) {
            var selectedEquipment = equipmentDao.getReferenceById(equipmentId);
            return equipmentMapping.toEquipmentDto(selectedEquipment);
        } else {
            return new ErrorStatusCodes(1, "Selected Equipment not found");
        }

    }
    @Override
    public void deleteEquipment(String equipmentId) {
            Optional<EquipmentEntity> foundEquipment = equipmentDao.findById(equipmentId);
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDto equipmentDto) {
            Optional<EquipmentEntity> findEquipment = equipmentDao.findById(equipmentId);
            if (!findEquipment.isPresent()) {
                throw new DataPersistException("Equipment not found");
            } else {
                findEquipment.get().setName(equipmentDto.getName());
                findEquipment.get().setStatus(equipmentDto.getStatus());
                findEquipment.get().setType(equipmentDto.getType());
            }
    }
}
