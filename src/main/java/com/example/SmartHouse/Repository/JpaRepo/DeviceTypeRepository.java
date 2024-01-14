package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.DeviceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceTypeRepository extends JpaRepository<DeviceTypeEntity, Integer> {
}
