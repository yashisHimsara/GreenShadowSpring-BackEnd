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
    public CropEntity toCropEntity(CropDto crop){
        return mapper.map(crop, CropEntity.class);
    }
    public List<CropDto> asCropDtoList(List<CropEntity> all){
        return mapper.map(all, new TypeToken<List<CropDto>>(){}.getType());
    }

    public StaffDto toStaffDto(StaffEntity staff){
        return mapper.map(staff, StaffDto.class);
    }
    public StaffEntity toStaffEntity(StaffDto staff){
        return mapper.map(staff, StaffEntity.class);
    }
    public List<StaffDto> toStaffDtoList(List<StaffEntity> all){
        return mapper.map(all, new TypeToken<List<StaffDto>>(){}.getType());
    }

    public EquipmentEntity toEquipmentEntity(EquipmentDto equipmentDto) {
        return mapper.map(equipmentDto, EquipmentEntity.class);
    }

    public List<EquipmentDto> toEquipmentDTOList(List<EquipmentEntity> all) {
        return mapper.map(all,new TypeToken<List<EquipmentDto>>(){}.getType());
    }

    public EquipmentDto toEquipmentDTO(EquipmentEntity equipmentEntity) {
        return mapper.map(equipmentEntity,EquipmentDto.class);
    }

    public MonitoringLogEntity toLogEntity(MonitoringLogDto monitoringLogDTO) {
        return mapper.map(monitoringLogDTO,MonitoringLogEntity.class);
    }

    public List<MonitoringLogDto> asLogDtoList(List<MonitoringLogEntity> all) {
        return mapper.map(all,new TypeToken<List<MonitoringLogDto>>(){}.getType());
    }

    public VehicleDto tovehicleDto(VehicleEntity vehicle){
        return mapper.map(vehicle, VehicleDto.class);
    }
    public  VehicleEntity toVehicleEntity(VehicleDto vehicle){
        return mapper.map(vehicle, VehicleEntity.class);
    }
    public VehicleDto toVehicleDto(VehicleEntity vehicleEntity) {
        return mapper.map(vehicleEntity,VehicleDto.class);
    }
}
