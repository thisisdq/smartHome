package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.ESP32GetDeviceDTO;
import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/getAllDevice")
    public ResponseEntity<List<DeviceEntity>> getAllDevice(){
        return new ResponseEntity<>(deviceService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/updateDevice")
    public ResponseEntity<DeviceEntity> updateDevice(@RequestBody DeviceEntity device){
        return new ResponseEntity<>(deviceService.updateDevice(device),HttpStatus.OK);
    }

//    @PostMapping("/getAllDeviceByUser")
//    @ResponseBody ResponseEntity getDeviceByUser(){
//        return new ResponseEntity(HttpStatus.OK)
//    }

    @PostMapping("/ESP32Fetch/{userID}")
    @ResponseBody public ResponseEntity<List<ESP32GetDeviceDTO>> ESP32GetDevice(@PathVariable("userID") Integer userID){
        System.out.println(userID);
        return new ResponseEntity<>(deviceService.ESP32_GET_DEVICES(userID), HttpStatus.OK);
    }

    @PostMapping("/ESP8266/temperature/{userID}/{temperature}")
    public ResponseEntity<String> ESP32SetTemperature(@PathVariable("userID") Integer userID,@PathVariable("temperature") Float temperature){
        deviceService.setTemperature(userID,temperature);
        return new ResponseEntity<>("temperature updated to : " + temperature,HttpStatus.OK);
    }

    @PostMapping("/ESP8266/humidity/{userID}/{humidity}")
    public ResponseEntity<String> ESP32SetHumidity(@PathVariable("humidity") Float humidity, @PathVariable("userID") Integer userID){
        deviceService.setHumidity(userID,humidity);
        return new ResponseEntity<>( "Humidity updated to : " + humidity, HttpStatus.OK);
    }

    
}
