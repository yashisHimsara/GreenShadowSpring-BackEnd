package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.Dao.FieldDao;
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
        FieldEntity saveField = fieldDao.save(fieldMapping.toFieldEntity((fieldDto)));
        if(saveField == null){
            throw new DataPersistException(("note not save"));
        }
    }

    @Override
    public List<FieldDto> getAllFields() {
        return null;
    }

    @Override
    public void updateField(String fieldCode, FieldDto fieldDto) {
        Optional<FieldEntity> findField = fieldDao.findById(fieldCode);
        if(!findField.isPresent()){
            throw new FieldNotFoundException("Field Not Found");
        }else {

            // TODO: 01/12/2024 methana aulk tiynw
//            findField.get().getFieldName(fieldDto.getFieldName());
        }
    }

    @Override
    public void deleteField(String fieldCode) {
        Optional<FieldEntity> foundField = fieldDao.findById(fieldCode);
        if(!foundField.isPresent()){
            throw new FieldNotFoundException("Field Not Found");
        }else {
            fieldDao.deleteById(fieldCode);
        }
    }

    @Override
    public FieldDto getSelectedFieldByName(String name) {
        return null;
    }

//    @Override
//    public void saveFieldStaff(FieldStaffDto fieldStaffDto) {
//
//    }
//
//    @Override
//    public void deleteFieldStaff(String fieldCode, String staffId) {
//
//    }
}
