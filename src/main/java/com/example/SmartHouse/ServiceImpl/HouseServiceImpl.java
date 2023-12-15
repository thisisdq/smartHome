package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Repository.JpaRepo.HouseRepository;
import com.example.SmartHouse.Service.FloorService;
import com.example.SmartHouse.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private FloorService floorService;

    @Override
    public List<HouseEntity> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<HouseEntity> findAllByUserId(Integer id) {
        List<HouseEntity> _house = houseRepository.findAllByUserId(id);
        for(HouseEntity h : _house){
            List<FloorEntity> floors = floorService.findAllByHouseID(h.getHouseID());
            h.setFloors(floors);
        }
        return _house;
    }
}
