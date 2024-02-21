package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.RoomEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {

    List<RoomEntity> findAll();

    List<RoomEntity> findAllByFloorId(Integer id);

    List<RoomEntity> findAllByFloorIdWithoutRoom(Integer id);
}
