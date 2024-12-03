package com.example.greenshadowbackend.service.impl;


import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.CropDao;
import com.example.greenshadowbackend.Dao.FieldDao;
import com.example.greenshadowbackend.dto.CropStatus;
import com.example.greenshadowbackend.dto.impl.CropDto;
import com.example.greenshadowbackend.entity.impl.CropEntity;
import com.example.greenshadowbackend.exception.CropNotFoundException;
import com.example.greenshadowbackend.service.CropService;
import com.example.greenshadowbackend.util.AppUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.greenshadowbackend.util.Mapping;
import com.example.greenshadowbackend.exception.DataPersistException;


import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
@Transactional
public class cropServiceImpl implements CropService {
    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping cropMapping;


    @Override
    public void saveCrop(CropDto cropDto) {
        cropDto.setCropCode(AppUtil.generateCropCode());
        CropEntity saveCrop=CropDao.save(cropMapping.toCropEntity(cropDto));
        if (saveCrop==null){
            throw new DataPersistException("Crop not saved");
        }

    }

    @Override
    public List<CropDto> getAllCrops() {
        return cropMapping.asCropDTOList(cropDao.findAll());
    }

    @Override
    public CropStatus getCrop(String cropId) {
        if (cropDao.existsById(cropId)){
            var selectedUser = cropDao.getReferenceById(cropId);
            return cropMapping.toCropDTO(selectedUser);
        }else {
            return new ErrorStatusCodes(1,"Selected Crop not found");
        }

    }

    @Override
    public void deleteCrop(String cropId) {
        Optional<CropEntity> foundCrop = cropDao.findById(cropId);
        if (!foundCrop.isPresent()){
            throw new CropNotFoundException("Crop Not Found");
        }else {
            cropDao.deleteById(cropId);
        }
    }

    @Override
    public void updateCrop(String cropId, CropDto cropDto) {
        Optional<CropEntity> findCrop =cropDao.findById(cropId);
        if (!findCrop.isPresent()){
            throw new CropNotFoundException("Crop Not Found");
        }else {
            findCrop.get().setCommonName(cropDto.getCommonName());
            findCrop.get().setScientificName(cropDto.getScientificName());
            findCrop.get().setImage(cropDto.getImage());
            findCrop.get().setCategory(cropDto.getCategory());
            findCrop.get().setSeason(cropDto.getSeason());
            findCrop.get().setField(cropDto.getFieldCode());
        }
    }
}
