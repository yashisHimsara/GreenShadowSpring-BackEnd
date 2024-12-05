package com.example.greenshadowbackend.controller;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.dto.LogStatus;
import com.example.greenshadowbackend.dto.impl.MonitoringLogDto;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.LogNotFoundException;
import com.example.greenshadowbackend.service.LogMonitoringService;
import com.example.greenshadowbackend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/log")
public class LogController {
    @Autowired
    private LogMonitoringService logMonitoringService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(@RequestBody MonitoringLogDto monitoringLogDto){
        try {
            logMonitoringService.saveLog(monitoringLogDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{logId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LogStatus getSelectedLog(@PathVariable("logId") String logId) {
        if (!RegexProcess.logIdMatcher(logId)) {
            return new ErrorStatusCodes(1, "Log Id is Not Valid");
        }
        return logMonitoringService.getLog(logId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitoringLogDto> getAllLog() {
        return logMonitoringService.getAllLogs();
    }

    @DeleteMapping(value = "/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable("logId") String logId) {
        try {
            if (!RegexProcess.logIdMatcher(logId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logMonitoringService.deleteLog(logId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (LogNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{logId}")
    public ResponseEntity<Void> updateLog(@PathVariable("logId") String logId, @RequestBody MonitoringLogDto monitoringLogDto) {
        try {
            if (!RegexProcess.logIdMatcher(logId) || monitoringLogDto == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logMonitoringService.updateLog(logId, monitoringLogDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (LogNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
