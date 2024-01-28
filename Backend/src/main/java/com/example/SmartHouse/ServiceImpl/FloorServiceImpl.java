package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Repository.JpaRepo.FloorRepository;
import com.example.SmartHouse.Service.FloorService;
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
    public List<FloorEntity> findAllByHouseID(Integer id) {
        List<FloorEntity> _floors = floorRepository.findAllByHouseID(id);
        for(FloorEntity f : _floors) {
            f.setRooms(roomService.findAllByFloorId(f.getFloorID()));
        }
        return _floors;
    }
}
