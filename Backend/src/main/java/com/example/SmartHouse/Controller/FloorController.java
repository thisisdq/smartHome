package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.RegisterFloorDTO;
import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Repository.JpaRepo.FloorRepository;
import com.example.SmartHouse.Service.FloorService;
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
public class FloorController {

    @Autowired
    private FloorService floorService;

    @Autowired
    private HouseService houseService;
    @Autowired
    private FloorRepository floorRepository;

    @PostMapping("/floors/getFloor/{houseID}")
    public ResponseEntity<List<FloorEntity>> getAllFloorByHouseID(@PathVariable("houseID") Integer houseID){
        return new ResponseEntity<>(floorService.findAllByHouseIDWithoutRoom(houseID), HttpStatus.OK);
    }

    @PostMapping("/floors/register")
    public ResponseEntity<FloorEntity> registerFloorByHouseID(@RequestBody RegisterFloorDTO registerFloorDTO){
        if(houseService.findByHouseID(registerFloorDTO.getHouseID()) != null){
            FloorEntity fe = registerFloorDTO.getFloorEntity();
            fe.setHouseID(registerFloorDTO.getHouseID());
            fe.setFloorID(null);
            return new ResponseEntity<>(floorRepository.save(fe), HttpStatus.OK);
        }
        return  null;
    }

    @PostMapping("devices/setAllInFloor")
    public ResponseEntity<FloorEntity> TurnOnOffAllDeviceInFloor(@RequestBody @NotNull TurnOnOffAllDTO turnOnOffAllDTO){
        int active = turnOnOffAllDTO.getValue() == 0 ? 0 : 1;
        return new ResponseEntity<>(floorService.TurnOnOffAllDeviceInFloor(turnOnOffAllDTO.getId(),active),HttpStatus.OK);
    }

}
