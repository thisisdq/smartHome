package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Repository.JpaRepo.DeviceRepository;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<DeviceEntity> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<DeviceEntity> findAllByRoomId(Integer id) {
        return  deviceRepository.findAllByRoomId(id);
    }
}
