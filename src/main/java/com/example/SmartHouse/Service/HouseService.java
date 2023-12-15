package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.HouseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HouseService {
    List<HouseEntity> findAll();

    List<HouseEntity> findAllByUserId(Integer id);
}
