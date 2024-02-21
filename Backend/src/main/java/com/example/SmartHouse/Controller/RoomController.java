package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.RegisterRoomDTO;
import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.RoomEntity;
import com.example.SmartHouse.Repository.JpaRepo.RoomRepository;
import com.example.SmartHouse.Service.FloorService;
import com.example.SmartHouse.Service.RoomService;
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
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private FloorService floorService;
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/rooms/getRoom/{floorID}")
    public ResponseEntity<List<RoomEntity>> getAllRoomByFloorID(@PathVariable("floorID") Integer floorID){
        return new ResponseEntity<>(roomService.findAllByFloorIdWithoutRoom(floorID), HttpStatus.OK);
    }

    @PostMapping("/rooms/register")
    public ResponseEntity<RoomEntity> registerRoomByFloorID(@RequestBody RegisterRoomDTO registerRoomDTO){
        FloorEntity fe = floorService.findFloorByID(registerRoomDTO.getFloorID());
        if(fe != null){
            RoomEntity re = registerRoomDTO.getRoomEntity();
            re.setRoomID(null);
            return new ResponseEntity<>(roomRepository.save(re), HttpStatus.OK) ;
        }
        return null;
    }

}
