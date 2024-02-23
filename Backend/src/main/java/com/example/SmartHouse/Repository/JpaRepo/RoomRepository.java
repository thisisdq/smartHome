package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.HouseEntity;
import com.example.SmartHouse.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("Select r from RoomEntity r WHERE r.floorID = :id")
    List<RoomEntity> findAllByFloorID(@Param("id") Integer id);
}
