package com.example.SmartHouse.Service;

import com.example.SmartHouse.DTO.ESP32GetDeviceDTO;
import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.DeviceEntity;

import java.util.List;

public interface DeviceService {

    List<DeviceEntity> findAll();

    List<DeviceEntity> findAllByRoomId(Integer id);

    DeviceEntity findById(Integer id);

    DeviceEntity updateDevice(DeviceEntity device);

    List<ESP32GetDeviceDTO> ESP32_GET_DEVICES(Integer userID);

//    void setTemperature(Integer userID, Float temperature);
//    void setHumidity(Integer userID, Float humidity);

    DeviceEntity getTemperatureDevice(Integer userID);

    DeviceEntity registerByRoomID(Integer roomID, DeviceEntity deviceEntity);

    void deleteDeviceByID(Integer deviceID);

    void turnOffTV(Integer userID);

    void TurnOnOffAllDeviceInRoom(Integer userID, Integer UHFR_ID, Integer value);
    void TurnOnOffAllDeviceInFloor(Integer userID, Integer UHFR_ID, Integer value);
    void TurnOnOffAllDeviceInHouse(Integer userID, Integer UHFR_ID, Integer value);


}
