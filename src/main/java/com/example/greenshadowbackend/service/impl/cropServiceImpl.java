package com.example.greenshadowbackend.service.impl;


import com.example.greenshadowbackend.Dao.CropDao;
import com.example.greenshadowbackend.Dao.FieldDao;
import com.example.greenshadowbackend.dto.impl.CropDto;
import com.example.greenshadowbackend.service.CropService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
@Transactional
public class cropServiceImpl implements CropService {
    @Autowired
    private CropDao cropDao;

    @Autowired
    private FieldDao fieldDao;

    @Override
    public void saveCrop(CropDto cropDto) {


    }

    @Override
    public List<CropDto> grtAllCrops() {
        return null;
    }

    @Override
    public void deleteCrop(String cropCode) {

    }

    @Override
    public void updateCrop(String cropcode, CropDto cropDto) {

    }

    @Override
    public CropDto getSelectedCropByName(String name) {
        return null;
    }
}
