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

    /*field Mapping-----*/

    public FieldDto tofieldDTO(FieldEntity fIeldEntity) {
        return mapper.map(fIeldEntity, FieldDto.class);
    }
    public FieldEntity toFIeldEntity(FieldDto fieldDto) {
        return mapper.map(fieldDto, FieldEntity.class);
    }
    public List<FieldDto> asFieldDTOList(List<FieldEntity> fIeldEntities) {
        return mapper.map(fIeldEntities, new TypeToken<List<FieldDto>>(){}.getType());
    }

    /*Crop Mapping-------*/
    public CropDto toCropDTO(CropEntity cropEntity){
        return mapper.map(cropEntity, CropDto.class);
    }
    public CropEntity toCropEntity(CropDto cropDto){
        return mapper.map(cropDto, CropEntity.class);

    }
    public List<CropDto> asCropDTOList(List<CropEntity> cropEntities){
        return mapper.map(cropEntities, new TypeToken<List<CropDto>>(){}.getType());
    }

    /*Staff Mapping-------*/
    public StaffDto toStaffDTO(StaffEntity staffEntity){
        return mapper.map(staffEntity, StaffDto.class);
    }

    public StaffEntity toStaffEntity(StaffDto staffDto){
        return mapper.map(staffDto , StaffEntity.class);
    }
    public List<StaffDto> asStaffDtoList(List<StaffEntity> staffEntities){
        return mapper.map(staffEntities, new TypeToken<List<StaffDto>>(){}.getType());
    }

    /*Vehicle Mapping--------------*/
    public VehicleDto toVehicleDto(VehicleEntity vehicleEntity){
        return mapper.map(vehicleEntity, VehicleDto.class);
    }
    public VehicleEntity toVehicleEntity(VehicleDto vehicleDto){
        return mapper.map(vehicleDto, VehicleEntity.class);
    }
    public List<VehicleDto> asVehicleDtoList(List<VehicleEntity> vehicleEntities){
        return mapper.map(vehicleEntities, new TypeToken<List<VehicleDto>>(){}.getType());
    }

    /* Equipment mapping--------*/

    public EquipmentEntity toEquipmentEntity(EquipmentDto equipmentDto) {
        return mapper.map(equipmentDto, EquipmentEntity.class);
    }

    public List<EquipmentDto> asEquipmentDtoList(List<EquipmentEntity> equipmentEntities) {
        return mapper.map(equipmentEntities,new TypeToken<List<EquipmentDto>>(){}.getType());
    }

    public EquipmentDto toEquipmentDto(EquipmentEntity equipmentEntity) {
        return mapper.map(equipmentEntity,EquipmentDto.class);
    }

    /*for log mapping------*/
    public MonitoringLogEntity toLogEntity(MonitoringLogDto monitoringLogDto) {
        return mapper.map(monitoringLogDto, MonitoringLogEntity.class);
    }

    public List<MonitoringLogDto> asLogDtoList(List<MonitoringLogEntity> logEntities) {
        return mapper.map(logEntities,new TypeToken<List<MonitoringLogDto>>(){}.getType());
    }
    public MonitoringLogDto toLogDto(MonitoringLogEntity monitoringLogEntity) {
        return mapper.map(monitoringLogEntity,MonitoringLogDto.class);
    }

    /* User Mapping */
    public UserDto toUserDto(UserEntity userEntity) {
        return mapper.map(userEntity, UserDto.class);
    }

    public UserEntity toUserEntity(UserDto userDto) {
        return mapper.map(userDto, UserEntity.class);
    }

    public List<UserDto> asUserDtoList(List<UserEntity> userEntities) {
        return mapper.map(userEntities, new TypeToken<List<UserDto>>() {}.getType());
    }
}
