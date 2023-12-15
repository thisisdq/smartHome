package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer> {

    @Query("Select d from DeviceEntity d Where d.roomID = :id")
    List<DeviceEntity> findAllByRoomId(@Param("id") Integer id);
}
