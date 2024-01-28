package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.RoomEntity;
import com.example.SmartHouse.Repository.JpaRepo.DeviceRepository;
import com.example.SmartHouse.Repository.JpaRepo.RoomRepository;
import com.example.SmartHouse.Service.DeviceService;
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
    public List<RoomEntity> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<RoomEntity> findAllByFloorId(Integer id) {
        List<RoomEntity> _rooms = roomRepository.findAllByFloorID(id);
        for(RoomEntity r : _rooms){
            r.setDevices(deviceService.findAllByRoomId(r.getRoomID()));
        }
        return _rooms;
    }
}
