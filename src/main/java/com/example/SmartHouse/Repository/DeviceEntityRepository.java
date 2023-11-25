package com.example.SmartHouse.Repository;

import com.example.SmartHouse.Entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceEntityRepository extends JpaRepository<DeviceEntity, Integer> {
}
