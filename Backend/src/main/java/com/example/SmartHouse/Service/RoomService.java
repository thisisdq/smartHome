package com.example.SmartHouse.Service;

import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.RoomEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {

    List<RoomEntity> findAll();

    RoomEntity findById(Integer id);

    List<RoomEntity> findAllByFloorId(Integer id);

    List<RoomEntity> findAllByFloorIdWithoutRoom(Integer id);

    RoomEntity TurnOnOffAllDeviceInRoom(Integer roomID, Integer active);

//    void setActivityOn(Integer roomID);

}
