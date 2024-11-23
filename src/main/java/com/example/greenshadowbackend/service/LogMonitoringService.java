package com.example.greenshadowbackend.service;

import com.example.greenshadowbackend.dto.impl.MonitoringLogDto;

import java.util.List;

public interface LogMonitoringService {
    void saveLog(MonitoringLogDto monitoringLogDto);

    List<MonitoringLogDto> getAllLogs();

    void deleteLog(String tempId);
}
