package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.DTO.ESP32GetDeviceDTO;
import com.example.SmartHouse.DTO.TurnOnOffAllDTO;
import com.example.SmartHouse.Entity.DeviceEntity;
import com.example.SmartHouse.Entity.DeviceTypeEntity;
import com.example.SmartHouse.Repository.JpaRepo.DeviceRepository;
import com.example.SmartHouse.Repository.JpaRepo.DeviceTypeRepository;
import com.example.SmartHouse.Repository.JpaRepo.RoomRepository;
import com.example.SmartHouse.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<DeviceEntity> findAll() {
        List<DeviceEntity> listDevice = deviceRepository.findAll();
        for(DeviceEntity device : listDevice){
            setDeviceTypeForDevice(device);
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
            setDeviceTypeForDevice(device);
        }
        return  deviceEntities;
    }

    @Override
    public DeviceEntity updateDevice(DeviceEntity device) {
        DeviceEntity _device = deviceRepository.findById(device.getId()).orElse(null);
        if(_device != null){
            _device.setIsRunning(device.getIsRunning());
            if(device.getDeviceValue() != null) {
                _device.setDeviceValue(device.getDeviceValue());
            }
            return deviceRepository.save(_device);
        }
        return null;
    }

    public void setDeviceTypeForDevice(DeviceEntity device){
        if(device.getDeviceTypeID() != null){
            DeviceTypeEntity deviceType = deviceTypeRepository.findById(device.getDeviceTypeID()).orElse(null);
            if(deviceType != null){
                device.setDeviceType(deviceType.getDeviceType());
            }
        }
    }

    @Override
    public List<ESP32GetDeviceDTO> ESP32_GET_DEVICES(Integer userID) {
        List<DeviceEntity> devices = deviceRepository.findDeviceByUserAccountIDwhenPortNotNull(userID);
        List<ESP32GetDeviceDTO> esp32GetDeviceDTOList = new ArrayList<>();
        for (DeviceEntity d : devices){
            ESP32GetDeviceDTO esp = new ESP32GetDeviceDTO();
            esp.setPORT(d.getDevicePort());
            esp.setIsRunning(d.getIsRunning());
            esp.setValue(d.getDeviceValue());
            esp32GetDeviceDTOList.add(esp);
        }
        return esp32GetDeviceDTOList;
    }

//    @Override
//    public void setTemperature(Integer userID, Float temperature) {
//        deviceRepository.setTemperature(userID,temperature);
//    }
//
//    @Override
//    public void setHumidity(Integer userID, Float humidity) {
//        deviceRepository.setHumidity(userID,humidity);
//    }

    @Override
    public DeviceEntity getTemperatureDevice(Integer userID) {
        return null;
    }


    @Override
    public DeviceEntity registerByRoomID(Integer roomID, DeviceEntity deviceEntity) {
        if(roomRepository.findById(roomID).orElse(null) != null){
            deviceEntity.setId(null);
            return deviceRepository.save(deviceEntity);
        }
        return null;
    }

    @Override
    public void deleteDeviceByID(Integer deviceID) {

        deviceRepository.deleteById(deviceID);
    }

    @Override
    public void turnOffTV(Integer userID) {
        deviceRepository.turnOffTV(userID);
    }

    @Override
    public void TurnOnOffAllDeviceInRoom(Integer userID, Integer UHFR_ID, Integer value) {
        deviceRepository.turnOnOffAllDeviceByRoomID(userID, UHFR_ID, value);
    }

    @Override
    public void TurnOnOffAllDeviceInFloor(Integer userID, Integer UHFR_ID, Integer value) {
        deviceRepository.turnOnOffAllDeviceByFloorID(userID, UHFR_ID, value);
    }

    @Override
    public void TurnOnOffAllDeviceInHouse(Integer userID, Integer UHFR_ID, Integer value) {
        deviceRepository.turnOnOffAllDeviceByHouseID(userID, UHFR_ID, value);
    }
}