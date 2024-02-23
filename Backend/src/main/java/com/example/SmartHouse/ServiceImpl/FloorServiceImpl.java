package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.RoomEntity;
import com.example.SmartHouse.Repository.JpaRepo.FloorRepository;
import com.example.SmartHouse.Repository.JpaRepo.RoomRepository;
import com.example.SmartHouse.Service.FloorService;
import com.example.SmartHouse.Service.HouseService;
import com.example.SmartHouse.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {


    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private RoomService roomService;


    @Override
    public List<FloorEntity> findAll() {
        return floorRepository.findAll();
    }

    @Override
    public FloorEntity findFloorByID(Integer floorID) {
        return floorRepository.findById(floorID).orElse(null);
    }

    @Override
    public List<FloorEntity> findAllByHouseID(Integer id) {
        List<FloorEntity> _floors = floorRepository.findAllByHouseID(id);
        for(FloorEntity f : _floors) {
            updateRoomForFloor(f);
        }
        return _floors;
    }

    @Override
    public List<FloorEntity> findAllByHouseIDWithoutRoom(Integer id) {
        return floorRepository.findAllByHouseID(id);
    }

    @Override
    public FloorEntity TurnOnOffAllDeviceInFloor(Integer floorID, Integer active) {
        FloorEntity _floor = floorRepository.findById(floorID).orElse(null);
        if(_floor != null){
            _floor.setFloorActive(active);
            floorRepository.save(_floor);
            updateRoomForFloor(_floor);
            for (RoomEntity r : _floor.getRooms()){
                roomService.TurnOnOffAllDeviceInRoom(r.getRoomID(),active);
            }
            return _floor;
        }
        return null;
    }

//    @Override
//    public void setActivityOn(Integer floorID) {
//        FloorEntity _floor = floorRepository.findById(floorID).orElse(null);
//        if(_floor != null){
//            _floor.setFloorActive(1);
//            floorRepository.save(_floor);
////            houseService.setActivityOn(_floor.getHouseID());
//        }
//    }

    void updateRoomForFloor(FloorEntity f){
        f.setRooms(roomService.findAllByFloorId(f.getFloorID()));
    }
}
