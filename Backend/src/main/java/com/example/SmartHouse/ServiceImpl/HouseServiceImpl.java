package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.FloorEntity;
import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Repository.JpaRepo.HouseRepository;
import com.example.SmartHouse.Repository.JpaRepo.UserAccountRepository;
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
    private UserAccountRepository userAccountRepository;

    @Autowired
    private FloorService floorService;

    @Override
    public List<HouseEntity> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<HouseEntity> findAllByUserIdWithFloor(Integer userId) {
        List<HouseEntity> _house = houseRepository.findAllByUserId(userId);
        for(HouseEntity h : _house){
            List<FloorEntity> floors = floorService.findAllByHouseID(h.getHouseID());
            h.setFloors(floors);
        }
        return _house;
    }

    @Override
    public List<HouseEntity> findAllByUserIdWithoutFloor(Integer userId) {
        List<HouseEntity> _house = houseRepository.findAllByUserId(userId);
        return _house;
    }

    @Override
    public UserAccountEntity registerHouseByUserID(Integer userID, HouseEntity houseEntity) {
        UserAccountEntity user = userAccountRepository.findUserById(userID).orElse(null);
        if(user != null ){
            houseEntity.setUserID(userID);
            houseRepository.save(houseEntity);
            return userAccountRepository.findUserById(userID).orElse(null);
        }
        else return null;

    }

    @Override
    public HouseEntity findByHouseID(Integer houseID) {
        return houseRepository.findById(houseID).orElse(null);
    }
}
