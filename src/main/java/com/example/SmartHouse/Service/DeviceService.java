package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Repository.DeviceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeviceService {

    List<DeviceEntity> findAll();
}
