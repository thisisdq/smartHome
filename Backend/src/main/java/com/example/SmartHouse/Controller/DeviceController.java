package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.ESP32GetDeviceDTO;
import com.example.SmartHouse.DTO.RegisterDeviceDTO;
import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Service.DeviceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @PostMapping("/ESP32/turnOffTv/{userID}")
    public ResponseEntity<String> turnOffTV(@PathVariable("userID") Integer userID){
        deviceService.turnOffTV(userID);
        return new ResponseEntity<>( "Turn off TV", HttpStatus.OK);
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

    @PostMapping("devices/register")
    public ResponseEntity<DeviceEntity> registerDeviceByRoomID(@RequestBody RegisterDeviceDTO registerDeviceDTO){
        DeviceEntity de = deviceService.registerByRoomID(registerDeviceDTO.getRoomID(), registerDeviceDTO.getDevice());
        if(de != null ){
            return new ResponseEntity<>(de,HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("devices/delete/{deviceID}")
    public void deleteDeviceById(@PathVariable("deviceID") Integer deviceID){
        deviceService.deleteDeviceByID(deviceID);
    }

}
