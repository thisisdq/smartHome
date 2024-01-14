package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Entity.DeviceTypeEntity;
import com.example.SmartHouse.Repository.JpaRepo.DeviceRepository;
import com.example.SmartHouse.Repository.JpaRepo.DeviceTypeRepository;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Override
    public List<DeviceEntity> findAll() {
        List<DeviceEntity> listDevice = deviceRepository.findAll();
        for(DeviceEntity device : listDevice){
            setDeviceTypeforDevice(device);
        }
        return listDevice;
    }

    @Override
    public DeviceEntity findById(Integer id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeviceEntity> findAllByRoomId(Integer id) {
        List<DeviceEntity> deviceEntities = deviceRepository.findAllByRoomId(id);
        for (DeviceEntity device : deviceEntities){
            setDeviceTypeforDevice(device);
        }
        return  deviceEntities;
    }

    @Override
    public DeviceEntity updateDevice(DeviceEntity device) {

        DeviceEntity _device = deviceRepository.findById(device.getId()).orElse(null);
        System.out.println(_device);

        if(_device != null){
            _device.setIsRunning(device.getIsRunning());
            _device.setDeviceValue(device.getDeviceValue());
            return deviceRepository.save(_device);
        }

        return null;
    }

    public void setDeviceTypeforDevice(DeviceEntity device){
        if(device.getDeviceTypeID() != null){
            DeviceTypeEntity deviceType = deviceTypeRepository.findById(device.getDeviceTypeID()).orElse(null);
            if(deviceType != null){
                device.setDeviceType(deviceType.getDeviceType());
            }
        }
    }
}