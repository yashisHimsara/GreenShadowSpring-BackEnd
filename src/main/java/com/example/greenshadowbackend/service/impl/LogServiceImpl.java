package com.example.greenshadowbackend.service.impl;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.Dao.LogMonitoringDao;
import com.example.greenshadowbackend.dto.LogStatus;
import com.example.greenshadowbackend.dto.impl.MonitoringLogDto;
import com.example.greenshadowbackend.entity.impl.FieldEntity;
import com.example.greenshadowbackend.entity.impl.MonitoringLogEntity;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.service.LogMonitoringService;
import com.example.greenshadowbackend.util.AppUtil;
import com.example.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LogServiceImpl implements LogMonitoringService {

    @Autowired
    private LogMonitoringDao logMonitoringDao;

    @Autowired
    private Mapping logMapping;


    @Override
    public void saveLog(MonitoringLogDto monitoringLogDto) {
        monitoringLogDto.setLogCode(AppUtil.generateLogCode());
        MonitoringLogEntity saveLog=logMonitoringDao.save(logMapping.toLogEntity(monitoringLogDto));
        if (saveLog==null){
            throw new DataPersistException("Log not saved");
        }

    }

    @Override
    public List<MonitoringLogDto> getAllLogs() {
        return logMapping.asLogDtoList(logMonitoringDao.findAll());
    }

    @Override
    public LogStatus getLog(String logId) {
        if (logMonitoringDao.existsById(logId)){
            var selectedLog=logMonitoringDao.getReferenceById(logId);
            return logMapping.toLogDto(selectedLog);
        }else {
            return new ErrorStatusCodes(1,"Selected Log not found");
        }
    }

    @Override
    public void deleteLog(String logId) {
        Optional<MonitoringLogEntity> foundLog=logMonitoringDao.findById(logId);
        if (!foundLog.isPresent()){
            throw new DataPersistException("Log not found");
        }else {
            logMonitoringDao.deleteById(logId);
        }

    }

    @Override
    public void updateLog(String logId, MonitoringLogDto logDTO) {
        Optional<MonitoringLogEntity> foundLog=logMonitoringDao.findById(logId);
        if (!foundLog.isPresent()){
            throw new DataPersistException("Log not found");
        }else {
            foundLog.get().setDate(logDTO.getDate());
            foundLog.get().setObservation(logDTO.getObservation());
            foundLog.get().setFieldEntity(logMapping.toFIeldEntity(logDTO.getFieldDto()));

        }

    }
}
