package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.DeviceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeviceService {

    List<DeviceEntity> findAll();

    List<DeviceEntity> findAllByRoomId(Integer id);

    DeviceEntity findById(Integer id);

    DeviceEntity updateDevice(DeviceEntity device);
}
