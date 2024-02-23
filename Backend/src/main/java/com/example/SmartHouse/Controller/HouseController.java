package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.RegisterHouseDTO;
import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Service.HouseService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@CrossOrigin("*")
public class HouseController {

    @Autowired
    private HouseService houseService;
    @PostMapping("/userAccount/getHouses/{userID}")
    public ResponseEntity<List<HouseEntity>> getAllHouseByUserId (@PathVariable("userID") Integer userID){
        return new ResponseEntity<>(houseService.findAllByUserIdWithoutFloor(userID), HttpStatus.OK);
    }

    @PostMapping("/userAccount/registerHouse")
    public ResponseEntity<UserAccountEntity> registerHouseByUserID (@RequestBody RegisterHouseDTO registerHouseDTO){
        UserAccountEntity _user = houseService.registerHouseByUserID(registerHouseDTO.getUserID(), registerHouseDTO.getHouseEntity());
        if(_user != null){
            return new ResponseEntity<>( _user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("devices/setAllInHouse")
    public ResponseEntity<HouseEntity> TurnOnOffAllDeviceInHouse(@RequestBody @NotNull TurnOnOffAllDTO turnOnOffAllDTO){
        int isRunning = turnOnOffAllDTO.getValue() == 0 ? 0 : 1;

        return new ResponseEntity<HouseEntity>(houseService.TurnOnOffAllDeviceInHouse(turnOnOffAllDTO.getId(),isRunning),HttpStatus.OK);
    }
}
