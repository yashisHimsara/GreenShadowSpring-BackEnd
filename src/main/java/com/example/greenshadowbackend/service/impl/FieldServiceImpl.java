package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.FieldDao;
import com.example.greenshadowbackend.dto.FieldStatus;
import com.example.greenshadowbackend.dto.impl.FieldDto;
import com.example.greenshadowbackend.entity.impl.FieldEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.FieldNotFoundException;
import com.example.greenshadowbackend.service.FieldService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {

     @Autowired
    private FieldDao fieldDao;

    @Autowired
    private Mapping fieldMapping;

    @Override
    public void saveField(FieldDto fieldDto) {
        fieldDto.setFieldCode(AppUtil.generateFieldCode());
        FieldEntity saveField = fieldDao.save(fieldMapping.toFIeldEntity(fieldDto));
        if (saveField==null){
            throw new DataPersistException("Field not Saved!");
        }

    }

    @Override
    public List<FieldDto> getAllFields() {
        return fieldMapping.asFieldDTOList(fieldDao.findAll());
    }



    @Override
    public void deleteField(String fieldId) {
        Optional<FieldEntity> foundField=fieldDao.findById(fieldId);
        if (!foundField.isPresent()){
            throw new FieldNotFoundException("Field not Found");
        }else {
            fieldDao.deleteById(fieldId);
        }
    }

    @Override
    public FieldStatus getField(String fieldId) {
        if (fieldDao.existsById(fieldId)){
            var selectedField=fieldDao.getReferenceById(fieldId);
            return fieldMapping.tofieldDTO(selectedField);
        }else {
            return new ErrorStatusCodes(1,"Selected Field not found");

        }
    }

    @Override
    public void updateField(String fieldId, FieldDto fieldDto) {
        Optional<FieldEntity> findField = fieldDao.findById(fieldId);
        if (!findField.isPresent()){
            throw new FieldNotFoundException("Field not Found");
        }else {
            findField.get().setFieldName(fieldDto.getFieldName());
            findField.get().setFieldLocation(fieldDto.getFieldLocation());
            findField.get().setFieldSize(fieldDto.getFieldSize());
            findField.get().setFieldImage(fieldDto.getFieldImage());
            findField.get().setFieldImage2(fieldDto.getFieldImage2());
        }
    }
}
