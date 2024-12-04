package com.example.greenshadowbackend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCropCode(){
        return "CROP-"+ UUID.randomUUID();
    }
    public static String generateFieldCode(){
        return "FIELD-"+ UUID.randomUUID();
    }
    public static String generateLogCode() {
        return "LOG-" + UUID.randomUUID();
    }
    public static String generateStaffCode() {
        return "STAFF-" + UUID.randomUUID();
    }
    public static String generateUserCode() {
        return "USER-" + UUID.randomUUID();
    }
    public static String generateVehicleCode() {
        return "VEHICLE-" + UUID.randomUUID();
    }
    public static String generateEquipmentCode() {
        return "EQUIPMENT-" + UUID.randomUUID();
    }
    public static String profilePicToBase64(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
