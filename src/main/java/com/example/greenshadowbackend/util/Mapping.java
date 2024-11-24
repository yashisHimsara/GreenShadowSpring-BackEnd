package com.example.greenshadowbackend.util;

import com.example.greenshadowbackend.dto.impl.CropDto;
import com.example.greenshadowbackend.dto.impl.FieldDto;
import com.example.greenshadowbackend.entity.impl.CropEntity;
import com.example.greenshadowbackend.entity.impl.FieldEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    public FieldDto toFieldDto(FieldEntity field){
        return mapper.map(field,FieldDto.class);
    }
    public FieldEntity toFieldEntity(FieldDto field){
        return mapper.map(field,FieldEntity.class);
    }
    public List<FieldDto> asFieldDtoList(List<FieldEntity> all) {
        return mapper.map(all, new TypeToken<List<FieldDto>>(){}.getType());
    }
    public CropDto toCropDto(CropEntity crop){
        return mapper.map(crop, CropDto.class);
    }

}
