package com.example.SmartHouse.Controller;

import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
