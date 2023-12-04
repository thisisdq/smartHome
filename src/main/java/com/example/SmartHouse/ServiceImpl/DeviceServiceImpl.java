package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Repository.DeviceEntityRepository;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceEntityRepository deviceEntityRepository;
    @Override
    public List<DeviceEntity> findAll() {
        return deviceEntityRepository.findAll();
    }
}
