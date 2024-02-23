package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.RoomEntity;
import com.example.SmartHouse.Repository.JpaRepo.DeviceRepository;
import com.example.SmartHouse.Repository.JpaRepo.RoomRepository;
import com.example.SmartHouse.Service.DeviceService;
import com.example.SmartHouse.Service.FloorService;
import com.example.SmartHouse.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private DeviceService deviceService;

    @Override
    public RoomEntity findById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public List<RoomEntity> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<RoomEntity> findAllByFloorId(Integer id) {
        List<RoomEntity> _rooms = roomRepository.findAllByFloorID(id);
        for(RoomEntity r : _rooms){
            updateDeviceForRoom(r);
        }
        return _rooms;
    }

    @Override
    public List<RoomEntity> findAllByFloorIdWithoutRoom(Integer id) {
        return roomRepository.findAllByFloorID(id);
    }

    @Override
    public RoomEntity TurnOnOffAllDeviceInRoom(Integer roomID, Integer active) {
        RoomEntity r = roomRepository.findById(roomID).orElse(null);
        if( r != null ){
            r.setRoomActive(active);
            roomRepository.save(r);
            updateDeviceForRoom(r);
            deviceService.TurnOnOffAllDeviceInRoom(roomID,active);
            return r;
        }
        return null;
    }

    void updateDeviceForRoom(RoomEntity r){
        r.setDevices(deviceService.findAllByRoomId(r.getRoomID()));
    }

//    @Override
//    public void setActivityOn(Integer roomID) {
//        RoomEntity _room = roomRepository.findById(roomID).orElse(null);
//        if(_room != null) {
//            _room.setRoomActive(1);
//            roomRepository.save(_room);
////            floorService.setActivityOn(_room.getFloorID());
//
//        }
//    }
}
