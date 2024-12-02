package com.example.greenshadowbackend.controller;

import com.example.greenshadowbackend.dto.CropStatus;
import com.example.greenshadowbackend.dto.impl.CropDto;
import com.example.greenshadowbackend.exception.DataPersistException;
import com.example.greenshadowbackend.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/crop")
public class CropController {
    @Autowired
    private CropService cropService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(@RequestBody CropDto cropDto){
        try{
            cropService.saveCrop(cropDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping(value = "/{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public CropStatus getSelectedNote(@PathVariable ("cropCode") String cropCode){
//        String regexForCropID = "^NOTE-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
//        Pattern regexPattern = Pattern.compile(regexForCropID);
//        var regexMatcher = regexPattern.matcher(cropCode);
//        if (!regexMatcher.matches()) {
//            return new SelectedUserAndNoteErrorStatus(1,"Note ID is not valid");
//        }
//        return cropService.get(cropCode);
}
