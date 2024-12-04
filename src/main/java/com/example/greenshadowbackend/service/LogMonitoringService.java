package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.LogStatus;
import com.example.greenshadowbackend.dto.impl.MonitoringLogDto;

import java.util.List;

public interface LogMonitoringService {
    void saveLog(MonitoringLogDto monitoringLogDto);
    List<MonitoringLogDto> getAllLogs();
    LogStatus getLog(String logId);
    void deleteLog(String logId);
    void updateLog(String logId, MonitoringLogDto monitoringLogDto);
}
