package com.example.greenshadowbackend.util;

import com.example.greenshadowbackend.dto.impl.*;
import com.example.greenshadowbackend.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    public FieldDto tofieldDTO(FieldEntity fIeldEntity) {
        return mapper.map(fIeldEntity, FieldDto.class);
    }
    public FieldEntity toFIeldEntity(FieldDto fieldDto) {
        return mapper.map(fieldDto, FieldEntity.class);
    }
    public List<FieldDto> asFieldDTOList(List<FieldEntity> fIeldEntities) {
        return mapper.map(fIeldEntities, new TypeToken<List<FieldDto>>(){}.getType());
    }
    

}
