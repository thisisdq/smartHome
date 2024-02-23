package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Integer> {

    @Query("Select f from FloorEntity f WHERE f.houseID = :id")
    List<FloorEntity> findAllByHouseID(@Param("id") Integer id);

    
}
