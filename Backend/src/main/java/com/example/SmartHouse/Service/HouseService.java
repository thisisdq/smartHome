package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HouseService {
    List<HouseEntity> findAll();

    HouseEntity findByHouseID(Integer houseID);

    UserAccountEntity registerHouseByUserID(Integer userID, HouseEntity houseEntity);

    List<HouseEntity> findAllByUserIdWithFloor(Integer userId);

    List<HouseEntity> findAllByUserIdWithoutFloor(Integer userId);

    HouseEntity TurnOnOffAllDeviceInHouse(Integer houseID,Integer active);

//    void setActivityOn(Integer houseID);
}
