package com.example.greenshadowbackend.controller;

import com.example.greenshadowbackend.CustomStatusCode.ErrorStatusCodes;
import com.example.greenshadowbackend.dto.VehicleStatus;
import com.example.greenshadowbackend.dto.impl.VehicleDto;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.exception.VehicleNotFoundException;
import com.example.greenshadowbackend.service.VehicleService;
import com.example.greenshadowbackend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        try {
            vehicleService.saveVehicle(vehicleDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleStatus getSelectedVehicle(@PathVariable("vehicleId") String vehicleId) {
        if (!RegexProcess.vehicleIdMatcher(vehicleId)) {
            return new ErrorStatusCodes(1, "Vehicle Id is Not Valid");
        }
        return vehicleService.getVehicle(vehicleId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @DeleteMapping(value = "/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleId") String vehicleId) {
        try {
            if (!RegexProcess.vehicleIdMatcher(vehicleId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            vehicleService.deleteVehicle(vehicleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (VehicleNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{vehicleId}")
    public ResponseEntity<Void> updateVehicle(@PathVariable("vehicleId") String vehicleId, @RequestBody VehicleDto vehicleDto) {
        try {
            if (!RegexProcess.vehicleIdMatcher(vehicleId) || vehicleDto == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            vehicleService.updateVehicle(vehicleId, vehicleDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (VehicleNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
