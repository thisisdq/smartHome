package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Integer> {

    @Query("Select h from HouseEntity h WHERE h.userID = :id")
    List<HouseEntity> findAllByUserId(@Param("id") Integer id);
}
