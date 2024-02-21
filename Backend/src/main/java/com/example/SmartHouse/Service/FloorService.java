package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.FloorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FloorService {
    List<FloorEntity> findAll();

    FloorEntity findFloorByID(Integer floorID);
    List<FloorEntity> findAllByHouseID(Integer id);
    List<FloorEntity> findAllByHouseIDWithoutRoom(Integer id);
}
