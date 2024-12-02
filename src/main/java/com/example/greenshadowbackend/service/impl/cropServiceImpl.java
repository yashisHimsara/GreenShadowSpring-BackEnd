package com.example.greenshadowbackend.service.impl;


import com.example.greenshadowbackend.Dao.CropDao;
import com.example.greenshadowbackend.Dao.FieldDao;
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
    private FieldDao fieldDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDto cropDto) {
        cropDto.setCropCode(AppUtil.generateCropCode());
        CropEntity saveCrop = cropDao.save(mapping.toCropEntity(cropDto));
        if(saveCrop==null){
            throw new DataPersistException("Crop notsave");
        }
    }

    @Override
    public List<CropDto> grtAllCrops() {
        return null;
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<CropEntity> foundCrop = cropDao.findById(cropCode);
        if(!foundCrop.isPresent()){
            throw new CropNotFoundException("Crop Not found");
        }else {
            cropDao.deleteById(cropCode);
        }
    }

    @Override
    public void updateCrop(String cropcode, CropDto cropDto) {
        Optional<CropEntity> findCrop = cropDao.findById(cropcode);
        if(!findCrop.isPresent()){
            throw new CropNotFoundException("Crop Not found");
        }else {
            findCrop.get().setCommonName(cropDto.getCommonName());
            findCrop.get().setScientificName(cropDto.getScientificName());
            findCrop.get().setImage(cropDto.getImage());
            findCrop.get().setCategory(cropDto.getCategory());
            findCrop.get().setSeason(cropDto.getSeason());
//            findCrop.get().setField(cropDto.getFieldCode());
        }

    }

    @Override
    public CropDto getSelectedCropByName(String name) {
        return null;
    }
}
